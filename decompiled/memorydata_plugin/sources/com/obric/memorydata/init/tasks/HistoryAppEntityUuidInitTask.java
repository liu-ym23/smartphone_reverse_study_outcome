package com.obric.memorydata.init.tasks;

import com.bytedance.lego.init.model.IInitTask;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.entity.fe;
import com.obric.memorydata.database.entity.fg;
import com.obric.memorydata.database.entity.fq;
import com.obric.memorydata.database.entity.fx;
import com.obric.memorydata.database.entity.fz;
import com.obric.memorydata.database.entity.ge;
import com.obric.memorydata.database.entity.go;
import com.obric.memorydata.database.entity.gu;
import com.obric.memorydata.database.entity.hb;
import com.obric.memorydata.database.entity.hh;
import com.obric.memorydata.database.entity.hl;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.api.MemoryTrackerOuter;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/init/tasks/HistoryAppEntityUuidInitTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "<init>", "()V", "run", "", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HistoryAppEntityUuidInitTask extends IInitTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9892a = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/init/tasks/HistoryAppEntityUuidInitTask$Companion;", "", "<init>", "()V", "KEY_UUID_INIT_COMPLETED", "", "BATCH_SIZE", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f9892a = new a(null);
    }

    public HistoryAppEntityUuidInitTask() {
    }

    private static final void a() {
        if (IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean("history_app_entity_uuid_init_task_finished", false) == true) goto L239;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HistoryAppEntityUuidInitTask", "start init history app entity uuid", false, 4, null);
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getContactRawDbDao().queryAll(), Iterable.class, "com.obric.memorydata.plugin"), 500), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r0.hasNext() == false) goto L22;
        List r8 = (List) ZeusTransformUtils.preCheckCast(r0.next(), List.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r9.hasNext() == false) goto L20;
        fx r11 = (fx) ZeusTransformUtils.preCheckCast(r9.next(), fx.class, "com.obric.memorydata.plugin");
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r11.getUuid(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L13;
    L16:
        boolean r13 = true;
    L17:
        if (r13 == false) goto L9;
        r11.setUuid(UUID.randomUUID().toString());
        r10.add(r11);
        goto L9
    L13:
        if (r12.length() == 0) goto L16;
        r13 = false;
        goto L17
    L20:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getContactRawDbDao().updateAll(r10);
        goto L6
    L22:
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getCallHistoryRawDbDao().queryAll(), Iterable.class, "com.obric.memorydata.plugin"), 500), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L24:
        if (r1.hasNext() == false) goto L40;
        List r14 = (List) ZeusTransformUtils.preCheckCast(r1.next(), List.class, "com.obric.memorydata.plugin");
        List r15 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L27:
        if (r16.hasNext() == false) goto L38;
        fq r17 = (fq) ZeusTransformUtils.preCheckCast(r16.next(), fq.class, "com.obric.memorydata.plugin");
        CharSequence r18 = (CharSequence) ZeusTransformUtils.preCheckCast(r17.getUuid(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r18 != null) goto L31;
    L34:
        boolean r19 = true;
    L35:
        if (r19 == false) goto L27;
        r17.setUuid(UUID.randomUUID().toString());
        r15.add(r17);
        goto L27
    L31:
        if (r18.length() == 0) goto L34;
        r19 = false;
        goto L35
    L38:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L24;
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getCallHistoryRawDbDao().updateAll(r15);
        goto L24
    L40:
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMessageRawDbDao().queryAll(), Iterable.class, "com.obric.memorydata.plugin"), 500), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L42:
        if (r2.hasNext() == false) goto L58;
        List r20 = (List) ZeusTransformUtils.preCheckCast(r2.next(), List.class, "com.obric.memorydata.plugin");
        List r110 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r21 = ((Iterable) ZeusTransformUtils.preCheckCast(r20, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L45:
        if (r21.hasNext() == false) goto L56;
        go r111 = (go) ZeusTransformUtils.preCheckCast(r21.next(), go.class, "com.obric.memorydata.plugin");
        CharSequence r112 = (CharSequence) ZeusTransformUtils.preCheckCast(r111.getUuid(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r112 != null) goto L49;
    L52:
        boolean r113 = true;
    L53:
        if (r113 == false) goto L45;
        r111.setUuid(UUID.randomUUID().toString());
        r110.add(r111);
        goto L45
    L49:
        if (r112.length() == 0) goto L52;
        r113 = false;
        goto L53
    L56:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r110, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L42;
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMessageRawDbDao().updateAll(r110);
        goto L42
    L58:
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getPhotoRawDbDao().queryAll(), Iterable.class, "com.obric.memorydata.plugin"), 500), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L60:
        if (r3.hasNext() == false) goto L76;
        List r22 = (List) ZeusTransformUtils.preCheckCast(r3.next(), List.class, "com.obric.memorydata.plugin");
        List r114 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r23 = ((Iterable) ZeusTransformUtils.preCheckCast(r22, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L63:
        if (r23.hasNext() == false) goto L74;
        hb r115 = (hb) ZeusTransformUtils.preCheckCast(r23.next(), hb.class, "com.obric.memorydata.plugin");
        CharSequence r116 = (CharSequence) ZeusTransformUtils.preCheckCast(r115.getUuid(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r116 != null) goto L67;
    L70:
        boolean r117 = true;
    L71:
        if (r117 == false) goto L63;
        r115.setUuid(UUID.randomUUID().toString());
        r114.add(r115);
        goto L63
    L67:
        if (r116.length() == 0) goto L70;
        r117 = false;
        goto L71
    L74:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r114, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L60;
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getPhotoRawDbDao().updateAll(r114);
        goto L60
    L76:
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAlbumRawDbDao().queryAll(), Iterable.class, "com.obric.memorydata.plugin"), 500), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L78:
        if (r4.hasNext() == false) goto L94;
        List r24 = (List) ZeusTransformUtils.preCheckCast(r4.next(), List.class, "com.obric.memorydata.plugin");
        List r118 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r25 = ((Iterable) ZeusTransformUtils.preCheckCast(r24, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L81:
        if (r25.hasNext() == false) goto L92;
        fg r119 = (fg) ZeusTransformUtils.preCheckCast(r25.next(), fg.class, "com.obric.memorydata.plugin");
        CharSequence r120 = (CharSequence) ZeusTransformUtils.preCheckCast(r119.getUuid(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r120 != null) goto L85;
    L88:
        boolean r121 = true;
    L89:
        if (r121 == false) goto L81;
        r119.setUuid(UUID.randomUUID().toString());
        r118.add(r119);
        goto L81
    L85:
        if (r120.length() == 0) goto L88;
        r121 = false;
        goto L89
    L92:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r118, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L78;
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAlbumRawDbDao().updateAll(r118);
        goto L78
    L94:
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getNoteRawDbDao().queryAll(), Iterable.class, "com.obric.memorydata.plugin"), 500), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L96:
        if (r5.hasNext() == false) goto L112;
        List r26 = (List) ZeusTransformUtils.preCheckCast(r5.next(), List.class, "com.obric.memorydata.plugin");
        List r122 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r27 = ((Iterable) ZeusTransformUtils.preCheckCast(r26, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L99:
        if (r27.hasNext() == false) goto L110;
        gu r123 = (gu) ZeusTransformUtils.preCheckCast(r27.next(), gu.class, "com.obric.memorydata.plugin");
        CharSequence r124 = (CharSequence) ZeusTransformUtils.preCheckCast(r123.getUuid(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r124 != null) goto L103;
    L106:
        boolean r125 = true;
    L107:
        if (r125 == false) goto L99;
        r123.setUuid(UUID.randomUUID().toString());
        r122.add(r123);
        goto L99
    L103:
        if (r124.length() == 0) goto L106;
        r125 = false;
        goto L107
    L110:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r122, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L96;
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getNoteRawDbDao().updateAll(r122);
        goto L96
    L112:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAlarmRawDbDao().queryAll(), Iterable.class, "com.obric.memorydata.plugin"), 500), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L114:
        if (r6.hasNext() == false) goto L130;
        List r28 = (List) ZeusTransformUtils.preCheckCast(r6.next(), List.class, "com.obric.memorydata.plugin");
        List r126 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r29 = ((Iterable) ZeusTransformUtils.preCheckCast(r28, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L117:
        if (r29.hasNext() == false) goto L128;
        fe r127 = (fe) ZeusTransformUtils.preCheckCast(r29.next(), fe.class, "com.obric.memorydata.plugin");
        CharSequence r128 = (CharSequence) ZeusTransformUtils.preCheckCast(r127.getUuid(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r128 != null) goto L121;
    L124:
        boolean r129 = true;
    L125:
        if (r129 == false) goto L117;
        r127.setUuid(UUID.randomUUID().toString());
        r126.add(r127);
        goto L117
    L121:
        if (r128.length() == 0) goto L124;
        r129 = false;
        goto L125
    L128:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r126, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L114;
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAlarmRawDbDao().updateAll(r126);
        goto L114
    L130:
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getScheduleRawDbDao().queryAll(), Iterable.class, "com.obric.memorydata.plugin"), 500), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L132:
        if (r7.hasNext() == false) goto L148;
        List r30 = (List) ZeusTransformUtils.preCheckCast(r7.next(), List.class, "com.obric.memorydata.plugin");
        List r130 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r31 = ((Iterable) ZeusTransformUtils.preCheckCast(r30, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L135:
        if (r31.hasNext() == false) goto L146;
        hl r131 = (hl) ZeusTransformUtils.preCheckCast(r31.next(), hl.class, "com.obric.memorydata.plugin");
        CharSequence r132 = (CharSequence) ZeusTransformUtils.preCheckCast(r131.getUuid(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r132 != null) goto L139;
    L142:
        boolean r133 = true;
    L143:
        if (r133 == false) goto L135;
        r131.setUuid(UUID.randomUUID().toString());
        r130.add(r131);
        goto L135
    L139:
        if (r132.length() == 0) goto L142;
        r133 = false;
        goto L143
    L146:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r130, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L132;
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getScheduleRawDbDao().updateAll(r130);
        goto L132
    L148:
        Iterator r32 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRecordingRawDbDao().queryAll(), Iterable.class, "com.obric.memorydata.plugin"), 500), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L150:
        if (r32.hasNext() == false) goto L166;
        List r33 = (List) ZeusTransformUtils.preCheckCast(r32.next(), List.class, "com.obric.memorydata.plugin");
        List r134 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r34 = ((Iterable) ZeusTransformUtils.preCheckCast(r33, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L153:
        if (r34.hasNext() == false) goto L164;
        hh r135 = (hh) ZeusTransformUtils.preCheckCast(r34.next(), hh.class, "com.obric.memorydata.plugin");
        CharSequence r136 = (CharSequence) ZeusTransformUtils.preCheckCast(r135.getUuid(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r136 != null) goto L157;
    L160:
        boolean r137 = true;
    L161:
        if (r137 == false) goto L153;
        r135.setUuid(UUID.randomUUID().toString());
        r134.add(r135);
        goto L153
    L157:
        if (r136.length() == 0) goto L160;
        r137 = false;
        goto L161
    L164:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r134, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L150;
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRecordingRawDbDao().updateAll(r134);
        goto L150
    L166:
        Iterator r35 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getFileRawDbDao().queryAll(), Iterable.class, "com.obric.memorydata.plugin"), 500), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L168:
        if (r35.hasNext() == false) goto L184;
        List r36 = (List) ZeusTransformUtils.preCheckCast(r35.next(), List.class, "com.obric.memorydata.plugin");
        List r138 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r37 = ((Iterable) ZeusTransformUtils.preCheckCast(r36, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L171:
        if (r37.hasNext() == false) goto L182;
        ge r139 = (ge) ZeusTransformUtils.preCheckCast(r37.next(), ge.class, "com.obric.memorydata.plugin");
        CharSequence r140 = (CharSequence) ZeusTransformUtils.preCheckCast(r139.getUuid(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r140 != null) goto L175;
    L178:
        boolean r141 = true;
    L179:
        if (r141 == false) goto L171;
        r139.setUuid(UUID.randomUUID().toString());
        r138.add(r139);
        goto L171
    L175:
        if (r140.length() == 0) goto L178;
        r141 = false;
        goto L179
    L182:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r138, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L168;
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getFileRawDbDao().updateAll(r138);
        goto L168
    L184:
        Iterator r38 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getCountdownRawDbDao().queryAll(), Iterable.class, "com.obric.memorydata.plugin"), 500), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L186:
        if (r38.hasNext() == false) goto L202;
        List r39 = (List) ZeusTransformUtils.preCheckCast(r38.next(), List.class, "com.obric.memorydata.plugin");
        List r142 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r40 = ((Iterable) ZeusTransformUtils.preCheckCast(r39, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L189:
        if (r40.hasNext() == false) goto L200;
        fz r143 = (fz) ZeusTransformUtils.preCheckCast(r40.next(), fz.class, "com.obric.memorydata.plugin");
        CharSequence r144 = (CharSequence) ZeusTransformUtils.preCheckCast(r143.getUuid(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r144 != null) goto L193;
    L196:
        boolean r145 = true;
    L197:
        if (r145 == false) goto L189;
        r143.setUuid(UUID.randomUUID().toString());
        r142.add(r143);
        goto L189
    L193:
        if (r144.length() == 0) goto L196;
        r145 = false;
        goto L197
    L200:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r142, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L186;
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getCountdownRawDbDao().updateAll(r142);
        goto L186
    L202:
        Iterator r41 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().queryAll(), Iterable.class, "com.obric.memorydata.plugin"), 500), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L204:
        if (r41.hasNext() == false) goto L220;
        List r42 = (List) ZeusTransformUtils.preCheckCast(r41.next(), List.class, "com.obric.memorydata.plugin");
        List r146 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r43 = ((Iterable) ZeusTransformUtils.preCheckCast(r42, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L207:
        if (r43.hasNext() == false) goto L218;
        RawMemoryEntity r147 = (RawMemoryEntity) ZeusTransformUtils.preCheckCast(r43.next(), RawMemoryEntity.class, "com.obric.memorydata.plugin");
        CharSequence r148 = (CharSequence) ZeusTransformUtils.preCheckCast(r147.getUuid(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r148 != null) goto L211;
    L214:
        boolean r149 = true;
    L215:
        if (r149 == false) goto L207;
        r147.setUuid(UUID.randomUUID().toString());
        r146.add(r147);
        goto L207
    L211:
        if (r148.length() == 0) goto L214;
        r149 = false;
        goto L215
    L218:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r146, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L204;
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().updateAll(r146);
        goto L204
    L220:
        Iterator r44 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().queryAll(), Iterable.class, "com.obric.memorydata.plugin"), 500), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L222:
        if (r44.hasNext() == false) goto L238;
        List r45 = (List) ZeusTransformUtils.preCheckCast(r44.next(), List.class, "com.obric.memorydata.plugin");
        List r46 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r47 = ((Iterable) ZeusTransformUtils.preCheckCast(r45, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L225:
        if (r47.hasNext() == false) goto L236;
        EpisodicMemoryEntity r150 = (EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r47.next(), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin");
        CharSequence r151 = (CharSequence) ZeusTransformUtils.preCheckCast(r150.getUuid(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r151 != null) goto L229;
    L232:
        boolean r152 = true;
    L233:
        if (r152 == false) goto L225;
        r150.setUuid(UUID.randomUUID().toString());
        r46.add(r150);
        goto L225
    L229:
        if (r151.length() == 0) goto L232;
        r152 = false;
        goto L233
    L236:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r46, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L222;
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().updateAll(r46);
        goto L222
    L238:
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("history_app_entity_uuid_init_task_finished", true);
    L239:
        MemoryTrackerOuter.INSTANCE.batchUploadOnce();
    }

    /* JADX INFO: renamed from: lambda$OOn3GYYcbB2LMSInO7-5W37AC_I, reason: not valid java name */
    public static /* synthetic */ void m664lambda$OOn3GYYcbB2LMSInO75W37AC_I() {
        a();
    }

    @Override // java.lang.Runnable
    public void run() {
        ThreadPoolContainer.Companion.getInstance().execute($$Lambda$HistoryAppEntityUuidInitTask$OOn3GYYcbB2LMSInO75W37AC_I.INSTANCE);
    }
}
