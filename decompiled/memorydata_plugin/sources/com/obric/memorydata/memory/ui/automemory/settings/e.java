package com.obric.memorydata.memory.ui.automemory.settings;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 *2\u00020\u0001:\u0002)*BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0018\u001a\u00020\u0019J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003JY\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006+"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfo;", "", "title", "", MemoryInfoSectionEditActivity.KIND_SCENE, "info", "Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfo$Section;", "customRule", "updateRule", "titleFormat", "subtitleFormat", "contentFormat", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfo$Section;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getScene", "getInfo", "()Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfo$Section;", "getCustomRule", "getUpdateRule", "getTitleFormat", "getSubtitleFormat", "getContentFormat", "toJson", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "Section", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10753a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10754b;
    private final String c;
    private final b d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005J\u0016\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfo$Companion;", "", "<init>", "()V", "KEY_TITLE", "", "KEY_SCENE", "KEY_INFO", "KEY_CUSTOM_RULE", "KEY_UPDATE_RULE", "KEY_TITLE_FORMAT", "KEY_SUBTITLE_FORMAT", "KEY_CONTENT_FORMAT", "fromJson", "Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfo;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "readSceneText", "obj", "Lorg/json/JSONObject;", "key", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final e a(String r15) {
            Intrinsics.checkNotNullParameter(r15, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L5;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
            a r14 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
            JSONObject r2 = new JSONObject(r15);     // Catch: Throwable -> L8
            String r4 = r2.optString("title");     // Catch: Throwable -> L8
            Intrinsics.checkNotNullExpressionValue(r4, "optString(...)");     // Catch: Throwable -> L8
            String r5 = r14.a(r2, MemoryInfoSectionEditActivity.KIND_SCENE);     // Catch: Throwable -> L8
            b r6 = b.f10755a.a(r2.optJSONObject("info"));     // Catch: Throwable -> L8
            String r7 = r2.optString("custom_rule");     // Catch: Throwable -> L8
            Intrinsics.checkNotNullExpressionValue(r7, "optString(...)");     // Catch: Throwable -> L8
            String r8 = r2.optString(MemoryInfoSectionEditActivity.KIND_UPDATE_RULE);     // Catch: Throwable -> L8
            Intrinsics.checkNotNullExpressionValue(r8, "optString(...)");     // Catch: Throwable -> L8
            String r9 = r2.optString("title_format");     // Catch: Throwable -> L8
            Intrinsics.checkNotNullExpressionValue(r9, "optString(...)");     // Catch: Throwable -> L8
            String r10 = r2.optString("subtitle_format");     // Catch: Throwable -> L8
            Intrinsics.checkNotNullExpressionValue(r10, "optString(...)");     // Catch: Throwable -> L8
            String r11 = r2.optString("content_format");     // Catch: Throwable -> L8
            Intrinsics.checkNotNullExpressionValue(r11, "optString(...)");     // Catch: Throwable -> L8
            Object r16 = Result.m1421constructorimpl(new e(r4, r5, r6, r7, r8, r9, r10, r11));     // Catch: Throwable -> L8
        L11:
            if (Result.m1424exceptionOrNullimpl(r16) == null) goto L15;
            r16 = new e(null, null, null, null, null, null, null, null, 255, null);
        L15:
            return (e) ZeusTransformUtils.preCheckCast(r16, e.class, "com.obric.memorydata.plugin");
        L8:
            th = move-exception;
            Result.Companion r17 = Result.Companion;
            r16 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L11
        L5:
            return new e(null, null, null, null, null, null, null, null, 255, null);
        }

        public final String a(JSONObject r12, String r13) {
            Intrinsics.checkNotNullParameter(r12, "obj");
            Intrinsics.checkNotNullParameter(r13, "key");
            JSONObject r11 = r12.optJSONObject(r13);
            if (r11 != null) goto L5;
            JSONArray r14 = r12.optJSONArray(r13);
            if (r14 == null) goto L22;
            Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r14.length()), Iterable.class, "com.obric.memorydata.plugin");
            Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r17 = r15.iterator();
        L10:
            if (r17.hasNext() == false) goto L21;
            Object r2 = r14.opt(((IntIterator) ZeusTransformUtils.preCheckCast(r17, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());
            String r3 = null;
            if (r2 == null) goto L18;
            String r4 = r2.toString();
            if (r4 == null) goto L18;
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L18;
            r3 = r4;
        L18:
            if (r3 == null) goto L10;
            r16.add(r3);
            goto L10
        L21:
            return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("、", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
        L22:
            String r18 = r12.optString(r13);
            Intrinsics.checkNotNullExpressionValue(r18, "optString(...)");
            return r18;
        L5:
            return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(b.f10755a.a(r11).b(), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("、", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfo$Section;", "", "title", "", "items", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "getItems", "()Ljava/util/List;", "toJson", "Lorg/json/JSONObject;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f10755a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f10756b;
        private final List<String> c;

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfo$Section$Companion;", "", "<init>", "()V", "fromJson", "Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfo$Section;", "obj", "Lorg/json/JSONObject;", "extractValue", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker r1) {
                this();
            }

            private final String b(JSONObject r7) {
                Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{EventBody.KEY_VALUE, ActivityLifecycle.NAME, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, AnnotatedPrivateKey.LABEL, "title"}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
            L4:
                if (r6.hasNext() == false) goto L18;
                Object r0 = r6.next();
                String r3 = (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
                boolean r5 = false;
                if (r7.has(r3) == false) goto L16;
                CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r7.optString(r3), CharSequence.class, "com.obric.memorydata.plugin");
                if (r4 != null) goto L10;
            L13:
                boolean r8 = true;
            L14:
                if (r8 == true) goto L16;
                r5 = true;
                goto L16
            L10:
                if (StringsKt.isBlank(r4) == true) goto L13;
                r8 = false;
            L16:
                if (r5 == false) goto L4;
            L19:
                String r9 = (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
                if (r9 == null) goto L23;
                String r10 = r7.optString(r9);
                Intrinsics.checkNotNullExpressionValue(r10, "optString(...)");
                return r10;
            L23:
                Iterator<String> r11 = r7.keys();
            L25:
                if (r11.hasNext() == false) goto L34;
                String r1 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(r1, "enabled") == true) goto L25;
                Object r2 = r7.opt(r1);
                if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L25;
                if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L25;
                return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
            L34:
                return "";
            L18:
                r0 = null;
                goto L19
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final b a(JSONObject r10) {
                String r9 = null;
                Object[] r11 = 0;
                Object[] r12 = 0;
                Object[] r13 = 0;
                Object[] r14 = 0;
                if (r10 == null) goto L5;
                JSONArray r0 = r10.optJSONArray("items");
                if (r0 != null) goto L10;
                String r15 = r10.optString("title");
                Intrinsics.checkNotNullExpressionValue(r15, "optString(...)");
                return new b(r15, r12 == true ? 1 : 0, 2, r11 == true ? 1 : 0);
            L10:
                Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r0.length()), Iterable.class, "com.obric.memorydata.plugin");
                Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
                Iterator r5 = r3.iterator();
            L12:
                if (r5.hasNext() == false) goto L31;
                Object r6 = r0.opt(((IntIterator) ZeusTransformUtils.preCheckCast(r5, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());
                if (ZeusTransformUtils.instanceOf(r6, JSONObject.class) == false) goto L19;
                String r7 = b.f10755a.b((JSONObject) ZeusTransformUtils.preCheckCast(r6, JSONObject.class, "com.obric.memorydata.plugin"));
                if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L29;
            L26:
                r7 = null;
            L29:
                if (r7 == null) goto L12;
                r4.add(r7);
                goto L12
            L19:
                if (ZeusTransformUtils.instanceOf(r6, String.class) == true) goto L21;
                if (r6 == null) goto L26;
                r7 = r6.toString();
                if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L26;
            L21:
                if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L24;
                r6 = null;
            L24:
                r7 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
                goto L29
            L31:
                List r16 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
                String r17 = r10.optString("title");
                Intrinsics.checkNotNullExpressionValue(r17, "optString(...)");
                return new b(r17, r16);
            L5:
                return new b(r9, r14 == true ? 1 : 0, 3, r13 == true ? 1 : 0);
            }
        }

        static {
            f10755a = new a(null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public b(String r3, List<String> r4) {
            List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "title");
            Intrinsics.checkNotNullParameter(r5, "items");
            this.f10756b = r3;
            this.c = r5;
        }

        public /* synthetic */ b(String r2, List r3, int r4, DefaultConstructorMarker r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            if ((r4 & 1) == 0) goto L6;
            r2 = "";
        L6:
            if ((r4 & 2) == 0) goto L8;
            r6 = CollectionsKt.emptyList();
        L8:
            this(r2, r6);
        }

        public static /* synthetic */ b a(b r1, String r2, List r3, int r4, Object r5) {
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            if ((r4 & 1) == 0) goto L6;
            r2 = r1.f10756b;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r6 = r1.c;
        L9:
            return r1.a(r2, r6);
        }

        public final b a(String r2, List<String> r3) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "title");
            Intrinsics.checkNotNullParameter(r1, "items");
            return new b(r2, r1);
        }

        public final String a() {
            return this.f10756b;
        }

        public final List<String> b() {
            return this.c;
        }

        public final JSONObject c() {
            JSONObject r0 = new JSONObject();
            r0.put("title", this.f10756b);
            JSONArray r1 = new JSONArray();
            Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(this.c, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            r1.put((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin"));
            goto L4
        L6:
            Unit r6 = Unit.INSTANCE;
            r0.put("items", r1);
            return r0;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10756b, r6.f10756b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f10756b.hashCode() * 31) + this.c.hashCode();
        }

        public String toString() {
            return "Section(title=" + this.f10756b + ", items=" + this.c + ')';
        }
    }

    static {
        f10753a = new a(null);
    }

    public e() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public e(String r2, String r3, b r4, String r5, String r6, String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, MemoryInfoSectionEditActivity.KIND_SCENE);
        Intrinsics.checkNotNullParameter(r4, "info");
        Intrinsics.checkNotNullParameter(r5, "customRule");
        Intrinsics.checkNotNullParameter(r6, "updateRule");
        Intrinsics.checkNotNullParameter(r7, "titleFormat");
        Intrinsics.checkNotNullParameter(r8, "subtitleFormat");
        Intrinsics.checkNotNullParameter(r9, "contentFormat");
        this.f10754b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ e(String r3, String r4, b r5, String r6, String r7, String r8, String r9, String r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r3 = "";
    L6:
        if ((r11 & 2) == 0) goto L9;
        r4 = "";
    L9:
        if ((r11 & 4) == 0) goto L12;
        String r1 = null;
        Object[] r2 = 0 == true ? 1 : 0;
        r5 = new b(r1, r2, 3, 0 == true ? 1 : 0);
    L12:
        if ((r11 & 8) == 0) goto L15;
        r6 = "";
    L15:
        if ((r11 & 16) == 0) goto L18;
        r7 = "";
    L18:
        if ((r11 & 32) == 0) goto L21;
        r8 = "";
    L21:
        if ((r11 & 64) == 0) goto L24;
        r9 = "";
    L24:
        if ((r11 & 128) == 0) goto L26;
        r10 = "";
    L26:
        this(r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ e a(e r9, String r10, String r11, b r12, String r13, String r14, String r15, String r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.f10754b;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.c;
    L11:
        if ((r18 & 4) == 0) goto L13;
        b r4 = r9.d;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = r9.e;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.f;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = r9.g;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = r9.h;
    L31:
        if ((r18 & 128) == 0) goto L33;
        String r1 = r9.i;
    L35:
        return r9.a(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final e a(String r11, String r12, b r13, String r14, String r15, String r16, String r17, String r18) {
        Intrinsics.checkNotNullParameter(r11, "title");
        Intrinsics.checkNotNullParameter(r12, MemoryInfoSectionEditActivity.KIND_SCENE);
        Intrinsics.checkNotNullParameter(r13, "info");
        Intrinsics.checkNotNullParameter(r14, "customRule");
        Intrinsics.checkNotNullParameter(r15, "updateRule");
        Intrinsics.checkNotNullParameter(r16, "titleFormat");
        Intrinsics.checkNotNullParameter(r17, "subtitleFormat");
        Intrinsics.checkNotNullParameter(r18, "contentFormat");
        return new e(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public final String a() {
        return this.f10754b;
    }

    public final String b() {
        return this.c;
    }

    public final b c() {
        return this.d;
    }

    public final String d() {
        return this.e;
    }

    public final String e() {
        return this.f;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f10754b, r6.f10754b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final String f() {
        return this.g;
    }

    public final String g() {
        return this.h;
    }

    public final JSONObject h() {
        JSONObject r0 = new JSONObject();
        r0.put("title", this.f10754b);
        r0.put(MemoryInfoSectionEditActivity.KIND_SCENE, this.c);
        r0.put("info", this.d.c());
        r0.put("custom_rule", this.e);
        r0.put(MemoryInfoSectionEditActivity.KIND_UPDATE_RULE, this.f);
        r0.put("title_format", this.g);
        r0.put("subtitle_format", this.h);
        r0.put("content_format", this.i);
        return r0;
    }

    public int hashCode() {
        return (((((((((((((this.f10754b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode();
    }

    public String toString() {
        return "MemoryInfo(title=" + this.f10754b + ", scene=" + this.c + ", info=" + this.d + ", customRule=" + this.e + ", updateRule=" + this.f + ", titleFormat=" + this.g + ", subtitleFormat=" + this.h + ", contentFormat=" + this.i + ')';
    }
}
