package com.obric.memorydata.personalcontext.search;

import android.database.Cursor;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.google.gson.Gson;
import com.obric.capabilitykit.entity.enums.AssetTypeEnum;
import com.obric.capabilitykit.search.FrameScore;
import com.obric.capabilitykit.search.PhotoScore;
import com.obric.capabilitykit.search.Similarity;
import com.obric.capabilitykit.search.VideoScore;
import com.obric.dejavu.library.DbKvResult;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao;
import com.obric.memorydata.database.entity.hb;
import com.obric.memorydata.database.entity.hr;
import com.obric.memorydata.database.entity.i;
import com.obric.memorydata.database.index.s;
import com.obric.memorydata.personalcontext.util.EmbeddingState;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0005J8\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00110\rj\b\u0012\u0004\u0012\u00020\u0011`\u000fH\u0002JH\u0010\u0012\u001a*\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00050\u00140\u00132\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0002J6\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00110\rj\b\u0012\u0004\u0012\u00020\u0011`\u000f2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00142\u0006\u0010\t\u001a\u00020\u0005H\u0002J$\u0010\u0018\u001a\u00020\u00192\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000fH\u0002J$\u0010\u001a\u001a\u00020\u00192\u001a\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u000fH\u0002J,\u0010\u001c\u001a\u00020\u00192\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J,\u0010\u001f\u001a\u00020\u00192\u001a\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u000f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001c\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020!H\u0002J\u0010\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020!H\u0002J\u0010\u0010(\u001a\u00020#2\u0006\u0010'\u001a\u00020!H\u0002J.\u0010)\u001a\u00020\u00192\b\u0010*\u001a\u0004\u0018\u00010!2\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000fH\u0002J.\u0010+\u001a\u00020\u00192\b\u0010,\u001a\u0004\u0018\u00010!2\u001a\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u000fH\u0002¨\u0006-"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/EntitySearchImageSimilarityUtil;", "", "<init>", "()V", "getImagesSimilarityRankByTextFromVectorDB", "", "entityIdList", "", "queryText", "callPackage", "convertToResponseStruct", "Lcom/obric/capabilitykit/search/Similarity;", "photoScoreList", "Ljava/util/ArrayList;", "Lcom/obric/memorydata/personalcontext/search/PhotoScoreEntity;", "Lkotlin/collections/ArrayList;", "videoSourceList", "Lcom/obric/memorydata/personalcontext/search/VideoScoreEntity;", "getPhotoIdList", "Lkotlin/Pair;", "", "", "getVideoFrameIdList", "videoIdMap", "getPhotoCopilotIdAndRowColumnList", "", "getVideoFrameCopilotIdAndRowColumnList", "videoScoreList", "getPhotoVectorList", "useVlm", "", "getVideoVectorList", "getQueryTextVectorList", "", "calculateImagesSimilarity", "", "textVector", "imageVector", "l2Normalize", "vec", "calculateNorm", "getPhotoScore", "queryTextVector", "getVideoScore", "queryTextVectorList", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f12310a = null;

    static {
        f12310a = new e();
    }

    private e() {
    }

    private final float a(float[] r8, float[] r9) {
        int r2 = 0;
        if (r8.length != r9.length) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L15;
        float r1 = 0.0f;
        float[] r10 = a(r8);
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r9.length), Collection.class, "com.obric.memorydata.plugin");
        int r4 = r9.length;
        int r5 = 0;
    L8:
        if (r5 >= r4) goto L10;
        r3.add(Float.valueOf(-r9[r5]));
        r5 = r5 + 1;
        goto L8
    L10:
        float[] r7 = a(CollectionsKt.toFloatArray((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")));
        int r11 = r10.length;
    L11:
        if (r2 >= r11) goto L13;
        r1 = r1 + (r10[r2] * r7[r2]);
        r2 = r2 + 1;
        goto L11
    L13:
        return r1;
    L15:
        throw new IllegalArgumentException(("向量长度不匹配：textVector.size=" + r8.length + ", imageVector.size=" + r9.length).toString());
    L5:
        r0 = false;
        goto L6
    }

    private final Similarity a(ArrayList<PhotoScoreEntity> r10, ArrayList<VideoScoreEntity> r11) {
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r9.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        PhotoScoreEntity r2 = (PhotoScoreEntity) ZeusTransformUtils.preCheckCast(r13.next(), PhotoScoreEntity.class, "com.obric.memorydata.plugin");
        r12.add(new PhotoScore(r2.getEntityId(), r2.getScore()));
        goto L4
    L6:
        List r14 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin");
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r15.iterator();
    L8:
        if (r17.hasNext() == false) goto L15;
        VideoScoreEntity r3 = (VideoScoreEntity) ZeusTransformUtils.preCheckCast(r17.next(), VideoScoreEntity.class, "com.obric.memorydata.plugin");
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r3.getFrameList(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r4.iterator();
    L11:
        if (r6.hasNext() == false) goto L13;
        FrameScoreEntity r7 = (FrameScoreEntity) ZeusTransformUtils.preCheckCast(r6.next(), FrameScoreEntity.class, "com.obric.memorydata.plugin");
        FrameScore r8 = new FrameScore(r7.getStartTime());
        r8.setScore(r7.getScore());
        r8.setEntityId(r7.getEntityId());
        r5.add(r8);
        goto L11
    L13:
        List r18 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
        r16.add(new VideoScore(r3.getEntityId(), r18));
        goto L8
    L15:
        return new Similarity(r14, (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin"));
    }

    private final ArrayList<VideoScoreEntity> a(Map<Long, String> r17, String r18) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r17, Map.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L11;
        List r5 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r0.keySet(), Iterable.class, "com.obric.memorydata.plugin"));
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r6 = s.a().getRawDaoByEntityType(-304);
        if (r6 == null) goto L15;
        Cursor r7 = r6.rawQueryForCursor((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT entityId FROM " + r6.getTableName() + " where photoEntityDbId in (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + ')'), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        ArrayList r8 = new ArrayList();
        int r9 = r7.getCount();
        int r10 = 0;
    L17:
        if (r10 >= r9) goto L19;
        r7.moveToPosition(r10);
        r8.add(r7.getString(r7.getColumnIndex("entityId")));
        r10 = r10 + 1;
        goto L17
    L19:
        r7.close();
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r6.queryByEntityIdListAndPackageName((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), r18), Iterable.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r11.iterator();
    L21:
        if (r13.hasNext() == false) goto L25;
        Object r14 = r13.next();
        if (ZeusTransformUtils.instanceOf(r14, hr.class) == false) goto L21;
        r12.add(r14);
        goto L21
    L25:
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Map r16 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r19 = r15.iterator();
    L27:
        if (r19.hasNext() == false) goto L32;
        Object r20 = r19.next();
        String r21 = String.valueOf(((hr) ZeusTransformUtils.preCheckCast(r20, hr.class, "com.obric.memorydata.plugin")).f());
        Object r22 = r16.get(r21);
        if (r22 != null) goto L31;
        r22 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r16.put(r21, r22);
    L31:
        ((List) ZeusTransformUtils.preCheckCast(r22, List.class, "com.obric.memorydata.plugin")).add(r20);
        goto L27
    L32:
        ArrayList<VideoScoreEntity> r23 = new ArrayList();
        Iterator r24 = r16.entrySet().iterator();
    L34:
        if (r24.hasNext() == false) goto L49;
        Map.Entry r25 = (Map.Entry) ZeusTransformUtils.preCheckCast(r24.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r26 = (String) ZeusTransformUtils.preCheckCast(r25.getKey(), String.class, "com.obric.memorydata.plugin");
        List r27 = (List) ZeusTransformUtils.preCheckCast(r25.getValue(), List.class, "com.obric.memorydata.plugin");
        String r28 = (String) ZeusTransformUtils.preCheckCast(r0.get(Long.valueOf(Long.parseLong(r26))), String.class, "com.obric.memorydata.plugin");
        CharSequence r29 = (CharSequence) ZeusTransformUtils.preCheckCast(r28, CharSequence.class, "com.obric.memorydata.plugin");
        if (r29 != null) goto L38;
    L41:
        boolean r30 = true;
    L42:
        if (r30 == true) goto L34;
        VideoScoreEntity r31 = new VideoScoreEntity(r28, new ArrayList());
        Iterator r32 = ((Iterable) ZeusTransformUtils.preCheckCast(r27, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L46:
        if (r32.hasNext() == false) goto L48;
        hr r33 = (hr) ZeusTransformUtils.preCheckCast(r32.next(), hr.class, "com.obric.memorydata.plugin");
        FrameScoreEntity r34 = new FrameScoreEntity(r33.a());
        r34.setEntityId(r33.getEntityId());
        r34.setId(r33.getId());
        r31.getFrameList().add(r34);
        goto L46
    L48:
        r23.add(r31);
        goto L34
    L38:
        if (r29.length() == 0) goto L41;
        r30 = false;
        goto L42
    L49:
        return r23;
    L15:
        return new ArrayList();
    L11:
        return new ArrayList();
    L5:
        if (r0.isEmpty() == true) goto L8;
        r4 = false;
        goto L9
    }

    private final Pair<ArrayList<PhotoScoreEntity>, Map<Long, String>> a(List<String> r18, String r19) {
        List<String> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L11;
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r4 = s.a().getRawDaoByEntityType(301);
        if (r4 == null) goto L15;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r4.queryByEntityIdListAndPackageName(r0, r19), Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r1.iterator();
    L18:
        if (r6.hasNext() == false) goto L22;
        Object r7 = r6.next();
        if (ZeusTransformUtils.instanceOf(r7, hb.class) == false) goto L18;
        r5.add(r7);
        goto L18
    L22:
        List r8 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
        ArrayList r9 = new ArrayList();
        Map r10 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L24:
        if (r11.hasNext() == false) goto L32;
        hb r12 = (hb) ZeusTransformUtils.preCheckCast(r11.next(), hb.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r12.b(), AssetTypeEnum.PHOTO.toString()) == true) goto L27;
        if (Intrinsics.areEqual(r12.b(), AssetTypeEnum.VIDEO.toString()) == false) goto L24;
        r10.put(Long.valueOf(r12.getId()), r12.getEntityId());
        goto L24
    L27:
        r9.add(new PhotoScoreEntity(r12.getId(), r12.getEntityId(), 0, null, null, 0.0f, 60, null));
        goto L24
    L32:
        return new Pair(r9, r10);
    L15:
        return new Pair(new ArrayList(), new HashMap());
    L11:
        return new Pair(new ArrayList(), new HashMap());
    L5:
        if (r2.isEmpty() == true) goto L8;
        r3 = false;
        goto L9
    }

    private final void a(ArrayList<PhotoScoreEntity> r11) {
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == false) goto L11;
        return;
    L11:
        IAppEntityVectorCopilotDao<i> r13 = s.a().getImageVectorCopilotDao(301);
        if (r13 != null) goto L14;
        return;
    L14:
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r3.iterator();
    L16:
        if (r5.hasNext() == false) goto L18;
        r4.add(Long.valueOf(((PhotoScoreEntity) ZeusTransformUtils.preCheckCast(r5.next(), PhotoScoreEntity.class, "com.obric.memorydata.plugin")).getId()));
        goto L16
    L18:
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r13.queryByRawDbIdListAndColumnContent((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), "file"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L20:
        if (r14.hasNext() == false) goto L36;
        i r6 = (i) ZeusTransformUtils.preCheckCast(r14.next(), i.class, "com.obric.memorydata.plugin");
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L23:
        if (r7.hasNext() == false) goto L30;
        Object r8 = r7.next();
        if (((PhotoScoreEntity) ZeusTransformUtils.preCheckCast(r8, PhotoScoreEntity.class, "com.obric.memorydata.plugin")).getId() != r6.b()) goto L27;
        boolean r9 = true;
    L28:
        if (r9 == false) goto L23;
    L31:
        PhotoScoreEntity r15 = (PhotoScoreEntity) ZeusTransformUtils.preCheckCast(r8, PhotoScoreEntity.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L34;
        r15.setCopilotId(r6.a());
    L34:
        if (r15 == null) goto L20;
        r15.setCopilotColumn(r6.c());
        goto L20
    L27:
        r9 = false;
        goto L28
    L30:
        r8 = null;
        goto L31
    L36:
        return;
    L5:
        if (r10.isEmpty() == true) goto L8;
        r12 = false;
        goto L9
    }

    private final void a(ArrayList<PhotoScoreEntity> r7, boolean r8) {
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
    L8:
        boolean r9 = true;
    L9:
        if (r9 == false) goto L11;
        return;
    L11:
        IAppEntityVectorCopilotDao<i> r10 = s.a().getImageVectorCopilotDao(301);
        if (r10 != null) goto L14;
        return;
    L14:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r11.hasNext() == false) goto L25;
        PhotoScoreEntity r2 = (PhotoScoreEntity) ZeusTransformUtils.preCheckCast(r11.next(), PhotoScoreEntity.class, "com.obric.memorydata.plugin");
        com.obric.dejavu.library.cipher.d r3 = new com.obric.memorydata.personalcontext.vectordb.d(r10.getTableName(), r8).c();
        if (r3 == null) goto L16;
        DbKvResult r4 = r3.a(String.valueOf(r2.getCopilotId()), true, true);
        if (r4 == null) goto L16;
        if (com.obric.memorydata.utils.b.a(r4.getVec()) == true) goto L16;
        r2.setVectorList(r4.getVec());
        goto L16
    L25:
        return;
    L5:
        if (r6.isEmpty() == true) goto L8;
        r9 = false;
        goto L9
    }

    private final void a(float[] r4, ArrayList<PhotoScoreEntity> r5) {
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == false) goto L11;
        return;
    L11:
        if (r4 != null) goto L13;
        return;
    L13:
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L15:
        if (r7.hasNext() == false) goto L20;
        PhotoScoreEntity r8 = (PhotoScoreEntity) ZeusTransformUtils.preCheckCast(r7.next(), PhotoScoreEntity.class, "com.obric.memorydata.plugin");
        float[] r1 = r8.getVectorList();
        if (r1 == null) goto L15;
        r8.setScore(f12310a.a(r4, r1));
        goto L15
    L20:
        return;
    L5:
        if (r3.isEmpty() == true) goto L8;
        r6 = false;
        goto L9
    }

    private final float[] a(String r7, boolean r8) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
    L8:
        boolean r9 = true;
    L9:
        if (r9 == false) goto L13;
        return null;
    L13:
        return com.obric.memorydata.personalcontext.util.d.a(com.obric.memorydata.personalcontext.util.d.f12365a, r7, r8, null, 4, null);
    L5:
        if (r6.length() == 0) goto L8;
        r9 = false;
        goto L9
    }

    private final float[] a(float[] r5) {
        float r4 = b(r5);
        int r2 = 0;
        if (r4 > 0.0f) goto L8;
        int r6 = r5.length;
        float[] r7 = new float[r6];
    L5:
        if (r2 >= r6) goto L7;
        r7[r2] = 0.0f;
        r2 = r2 + 1;
        goto L5
    L7:
        return r7;
    L8:
        int r0 = r5.length;
        float[] r1 = new float[r0];
    L9:
        if (r2 >= r0) goto L11;
        r1[r2] = r5[r2] / r4;
        r2 = r2 + 1;
        goto L9
    L11:
        return r1;
    }

    private final float b(float[] r6) {
        int r5 = r6.length;
        double r0 = 0.0d;
        int r2 = 0;
    L3:
        if (r2 >= r5) goto L6;
        double r3 = r6[r2];
        r0 = r0 + (r3 * r3);
        r2 = r2 + 1;
        goto L3
    L6:
        return (float) Math.sqrt(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    private final void b(ArrayList<VideoScoreEntity> r14) {
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L5;
    L8:
        ?? r15 = true;
    L9:
        if (r15 == false) goto L11;
        return;
    L11:
        IAppEntityVectorCopilotDao<i> r16 = s.a().getImageVectorCopilotDao(-304);
        if (r16 != null) goto L14;
        return;
    L14:
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r3.iterator();
    L16:
        if (r5.hasNext() == false) goto L22;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(((VideoScoreEntity) ZeusTransformUtils.preCheckCast(r5.next(), VideoScoreEntity.class, "com.obric.memorydata.plugin")).getFrameList(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r6.iterator();
    L19:
        if (r8.hasNext() == false) goto L21;
        r7.add((FrameScoreEntity) ZeusTransformUtils.preCheckCast(r8.next(), FrameScoreEntity.class, "com.obric.memorydata.plugin"));
        goto L19
    L21:
        CollectionsKt.addAll(r4, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        goto L16
    L22:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r9.iterator();
    L24:
        if (r11.hasNext() == false) goto L26;
        r10.add(Long.valueOf(((FrameScoreEntity) ZeusTransformUtils.preCheckCast(r11.next(), FrameScoreEntity.class, "com.obric.memorydata.plugin")).getId()));
        goto L24
    L26:
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r16.queryByRawDbIdListAndColumnContent((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin"), "file"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L28:
        if (r17.hasNext() == false) goto L66;
        i r12 = (i) ZeusTransformUtils.preCheckCast(r17.next(), i.class, "com.obric.memorydata.plugin");
        Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L30:
        FrameScoreEntity r19 = null;
        Object r20 = null;
        r19 = null;
        if (r18.hasNext() == false) goto L47;
        Object r21 = r18.next();
        Iterator r22 = ((Iterable) ZeusTransformUtils.preCheckCast(((VideoScoreEntity) ZeusTransformUtils.preCheckCast(r21, VideoScoreEntity.class, "com.obric.memorydata.plugin")).getFrameList(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L34:
        if (r22.hasNext() == false) goto L41;
        Object r23 = r22.next();
        if (((FrameScoreEntity) ZeusTransformUtils.preCheckCast(r23, FrameScoreEntity.class, "com.obric.memorydata.plugin")).getId() != r12.b()) goto L38;
        ?? r24 = true;
    L39:
        if (r24 == false) goto L34;
    L42:
        if (r23 == null) goto L44;
        ?? r25 = true;
    L45:
        if (r25 == false) goto L30;
    L48:
        VideoScoreEntity r26 = (VideoScoreEntity) ZeusTransformUtils.preCheckCast(r21, VideoScoreEntity.class, "com.obric.memorydata.plugin");
        if (r26 == null) goto L62;
        ArrayList<FrameScoreEntity> r27 = r26.getFrameList();
        if (r27 == null) goto L62;
        Iterator r28 = ((Iterable) ZeusTransformUtils.preCheckCast(r27, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L54:
        if (r28.hasNext() == false) goto L61;
        Object r29 = r28.next();
        if (((FrameScoreEntity) ZeusTransformUtils.preCheckCast(r29, FrameScoreEntity.class, "com.obric.memorydata.plugin")).getId() != r12.b()) goto L58;
        ?? r30 = true;
    L59:
        if (r30 == false) goto L54;
        r20 = r29;
        goto L61
    L58:
        r30 = false;
    L61:
        r19 = (FrameScoreEntity) ZeusTransformUtils.preCheckCast(r20, FrameScoreEntity.class, "com.obric.memorydata.plugin");
    L62:
        if (r19 == null) goto L64;
        r19.setCopilotId(r12.a());
    L64:
        if (r19 == null) goto L28;
        r19.setCopilotColumn(r12.c());
        goto L28
    L44:
        r25 = false;
        goto L45
    L38:
        r24 = false;
        goto L39
    L41:
        r23 = null;
        goto L42
    L47:
        r21 = null;
        goto L48
    L66:
        return;
    L5:
        if (r13.isEmpty() == true) goto L8;
        r15 = false;
        goto L9
    }

    private final void b(ArrayList<VideoScoreEntity> r8, boolean r9) {
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
    L8:
        boolean r10 = true;
    L9:
        if (r10 == false) goto L11;
        return;
    L11:
        IAppEntityVectorCopilotDao<i> r11 = s.a().getImageVectorCopilotDao(-304);
        if (r11 != null) goto L14;
        return;
    L14:
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r12.hasNext() == false) goto L28;
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(((VideoScoreEntity) ZeusTransformUtils.preCheckCast(r12.next(), VideoScoreEntity.class, "com.obric.memorydata.plugin")).getFrameList(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L19:
        if (r2.hasNext() == false) goto L16;
        FrameScoreEntity r3 = (FrameScoreEntity) ZeusTransformUtils.preCheckCast(r2.next(), FrameScoreEntity.class, "com.obric.memorydata.plugin");
        com.obric.dejavu.library.cipher.d r4 = new com.obric.memorydata.personalcontext.vectordb.d(r11.getTableName(), r9).c();
        if (r4 == null) goto L19;
        DbKvResult r5 = r4.a(String.valueOf(r3.getCopilotId()), true, true);
        if (r5 == null) goto L19;
        if (com.obric.memorydata.utils.b.a(r5.getVec()) == true) goto L19;
        r3.setVectorList(r5.getVec());
        goto L19
    L28:
        return;
    L5:
        if (r7.isEmpty() == true) goto L8;
        r10 = false;
        goto L9
    }

    private final void b(float[] r5, ArrayList<VideoScoreEntity> r6) {
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r7 == false) goto L11;
        return;
    L11:
        if (r5 != null) goto L13;
        return;
    L13:
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L15:
        if (r8.hasNext() == false) goto L23;
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(((VideoScoreEntity) ZeusTransformUtils.preCheckCast(r8.next(), VideoScoreEntity.class, "com.obric.memorydata.plugin")).getFrameList(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L18:
        if (r9.hasNext() == false) goto L15;
        FrameScoreEntity r1 = (FrameScoreEntity) ZeusTransformUtils.preCheckCast(r9.next(), FrameScoreEntity.class, "com.obric.memorydata.plugin");
        float[] r2 = r1.getVectorList();
        if (r2 == null) goto L18;
        r1.setScore(f12310a.a(r5, r2));
        goto L18
    L23:
        return;
    L5:
        if (r4.isEmpty() == true) goto L8;
        r7 = false;
        goto L9
    }

    public final String a(List<String> r7, String r8, String r9) {
        List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "callPackage");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L33;
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L14;
    L17:
        boolean r4 = true;
    L18:
        if (r4 == true) goto L33;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L22;
        boolean r5 = true;
    L23:
        if (r5 == true) goto L33;
        if (com.obric.memorydata.personalcontext.util.c.f12363a.b() != EmbeddingState.USE_VLM) goto L28;
        r2 = true;
    L28:
        float[] r11 = a(r8, r2);
        if (com.obric.memorydata.utils.b.a(r11) == false) goto L31;
        return null;
    L31:
        Pair<ArrayList<PhotoScoreEntity>, Map<Long, String>> r12 = a(r10, r9);
        ArrayList<PhotoScoreEntity> r6 = (ArrayList) ZeusTransformUtils.preCheckCast(r12.component1(), ArrayList.class, "com.obric.memorydata.plugin");
        ArrayList<VideoScoreEntity> r13 = a((Map) ZeusTransformUtils.preCheckCast(r12.component2(), Map.class, "com.obric.memorydata.plugin"), r9);
        a(r6);
        b(r13);
        a(r6, r2);
        b(r13, r2);
        a(r11, r6);
        b(r11, r13);
        return new Gson().toJson(a(r6, r13));
    L22:
        r5 = false;
        goto L23
    L14:
        if (r3.isEmpty() == true) goto L17;
        r4 = false;
    L33:
        return null;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }
}
