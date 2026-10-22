package com.obric.memorydata.middleware.impl.playground;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\b\b\u0000\u0018\u0000 +2\u00020\u0001:\u0003)*+B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007J*\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u0007H\u0002J(\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J2\u0010\u001b\u001a\u00020\u00172\b\u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0010H\u0002J0\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0010H\u0002J\u0014\u0010\u001e\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0007H\u0002J\f\u0010\u001f\u001a\u00020\r*\u00020\u0012H\u0002J\f\u0010\u001f\u001a\u00020\r*\u00020\u0018H\u0002J\u001c\u0010 \u001a\u00020\r*\u00020\u00122\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0002J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120$2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120$*\u00020\u0012H\u0002J\u0010\u0010&\u001a\u0004\u0018\u00010\u0012*\u0004\u0018\u00010\u0001H\u0002J\f\u0010'\u001a\u00020\u0010*\u00020\u0007H\u0002J\f\u0010(\u001a\u00020\u0010*\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/obric/memorydata/middleware/impl/playground/EntityResolver;", "", "entityStore", "Lcom/obric/memorydata/middleware/impl/playground/EntityStore;", "<init>", "(Lcom/obric/memorydata/middleware/impl/playground/EntityStore;)V", "preparePayload", "", "payload", "processResult", "rawResult", "sourceIntent", "recordSuccessfulDeletion", "", "preparedPayload", "transformObject", "", EventBody.KEY_VALUE, "Lorg/json/JSONObject;", "expandEntities", "inheritedActionName", "containerKey", "transformArray", "Lcom/obric/memorydata/middleware/impl/playground/EntityResolver$TransformResult;", "Lorg/json/JSONArray;", "actionName", "parentKey", "transformValue", "arrayElement", "transformString", "forDispatch", "normalizeTimes", "normalizeTime", "timeField", "timestampField", "extractActions", "", "targetEntities", "asJsonObject", "isJsonObjectCandidate", "containsEcaCandidate", "ExpandedEntities", "TransformResult", "Companion", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f11807a = null;
    private static final Regex c = null;
    private static final Regex d = null;
    private static final Set<String> e = null;
    private static final Set<String> f = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f11808b;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050#¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%¨\u0006("}, d2 = {"Lcom/obric/memorydata/middleware/impl/playground/EntityResolver$Companion;", "", "<init>", "()V", "CONTENT", "", "ECA_CONTENT", "JOBS", "ACTIONS", "ACTION_NAME", "INPUT_PARAMS", "TARGETS", "VALUE", "ID", "OFFICE_SEND_MESSAGE", "OFFICE_TARGET_ID", "CONTACTS_DELETE", "PHONE_DELETE", "CLOCK_DELETE_COUNTDOWN", "CREATE_TIME", "CREATE_TIME_STAMP", "LAST_MODIFIED_TIME", "LAST_MODIFIED_TIME_STAMP", "ECA_ID_CAMEL", "ECA_ID_COMPACT", "ECA_ID_SNAKE", "ECA_PREFIX", "LOCAL_ENTITY_PREFIX", "ECA_ID_REGEX", "Lkotlin/text/Regex;", "getECA_ID_REGEX", "()Lkotlin/text/Regex;", "ECA_ID_CANDIDATE_REGEX", "getECA_ID_CANDIDATE_REGEX", "PASSTHROUGH_ACTIONS", "", "getPASSTHROUGH_ACTIONS", "()Ljava/util/Set;", "ECA_REQUIRED_ACTIONS", "getECA_REQUIRED_ACTIONS", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/middleware/impl/playground/EntityResolver$ExpandedEntities;", "", "entities", "", "Lorg/json/JSONObject;", "<init>", "(Ljava/util/List;)V", "getEntities", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<JSONObject> f11809a;

        public b(List<? extends JSONObject> r3) {
            List<JSONObject> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "entities");
            this.f11809a = r4;
        }

        public final List<JSONObject> a() {
            return this.f11809a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11809a, r6.f11809a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f11809a.hashCode();
        }

        public String toString() {
            return "ExpandedEntities(entities=" + this.f11809a + ')';
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.middleware.impl.playground.c$c, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/middleware/impl/playground/EntityResolver$TransformResult;", "", EventBody.KEY_VALUE, "changed", "", "<init>", "(Ljava/lang/Object;Z)V", "getValue", "()Ljava/lang/Object;", "getChanged", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class C0639c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f11810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f11811b;

        public C0639c(Object r1, boolean r2) {
            this.f11810a = r1;
            this.f11811b = r2;
        }

        public final Object a() {
            return this.f11810a;
        }

        public final boolean b() {
            return this.f11811b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0639c.class) == true) goto L8;
            return false;
        L8:
            C0639c r6 = (C0639c) ZeusTransformUtils.preCheckCast(r5, C0639c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11810a, r6.f11810a) == true) goto L12;
            return false;
        L12:
            if (this.f11811b == r6.f11811b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            Object r0 = this.f11810a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + Boolean.hashCode(this.f11811b);
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "TransformResult(value=" + this.f11810a + ", changed=" + this.f11811b + ')';
        }
    }

    static {
        f11807a = new a(null);
        c = new Regex("^\\$E_[A-Za-z0-9]+$");
        d = new Regex("\\$E_[A-Za-z0-9]+");
        e = SetsKt.setOf(new String[]{"System_UserConfirm", "System_UserSelect", "System_MultiUserSelect", "System_QAWithSearch"});
        f = SetsKt.setOf("Phone_Delete");
    }

    public c(d r2) {
        Intrinsics.checkNotNullParameter(r2, "entityStore");
        this.f11808b = r2;
    }

    private final C0639c a(Object r7, boolean r8, String r9, String r10, boolean r11) {
        if (ZeusTransformUtils.instanceOf(r7, JSONObject.class) == false) goto L6;
        return new C0639c(r7, a((JSONObject) ZeusTransformUtils.preCheckCast(r7, JSONObject.class, "com.obric.memorydata.plugin"), r8, r9, r10));
    L6:
        if (ZeusTransformUtils.instanceOf(r7, JSONArray.class) == false) goto L9;
        return a((JSONArray) ZeusTransformUtils.preCheckCast(r7, JSONArray.class, "com.obric.memorydata.plugin"), r8, r9, r10);
    L9:
        if (ZeusTransformUtils.instanceOf(r7, String.class) == false) goto L12;
        return a((String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11);
    L12:
        return new C0639c(r7, false);
    }

    private final C0639c a(String r7, boolean r8, String r9, String r10, boolean r11) {
        if (r8 == false) goto L5;
        Object r2 = null;
        if (c(r7) == false) goto L28;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L10
        c r3 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        Object r4 = Result.m1421constructorimpl(new JSONObject(r7));     // Catch: Throwable -> L10
    L12:
        Throwable r5 = Result.m1424exceptionOrNullimpl(r4);
        if (r5 != null) goto L16;
    L18:
        JSONObject r6 = (JSONObject) ZeusTransformUtils.preCheckCast(r4, JSONObject.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L28;
        if (a(r6, r8, r9, r10) == false) goto L24;
        return new C0639c(r6.toString(), true);
    L24:
        return new C0639c(r7, false);
    L16:
        if (d(r7) == true) goto L26;
        r4 = null;
        goto L18
    L26:
        throw new EntityResolutionException("embedded ECA command must be a JSON object", r5);
    L10:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L28:
        if (c.matches((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L30;
        List<JSONObject> r13 = this.f11808b.b(r7);
        if (r13.isEmpty() == true) goto L34;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
        d r0 = this.f11808b;
        Iterator r15 = r14.iterator();
    L37:
        if (r15.hasNext() == false) goto L41;
        Object r16 = r15.next();
        if (r0.a((JSONObject) ZeusTransformUtils.preCheckCast(r16, JSONObject.class, "com.obric.memorydata.plugin")) == false) goto L37;
        r2 = r16;
    L41:
        JSONObject r17 = (JSONObject) ZeusTransformUtils.preCheckCast(r2, JSONObject.class, "com.obric.memorydata.plugin");
        if (r17 != null) goto L59;
        if (Intrinsics.areEqual(r9, "Office_SendMessage") == true) goto L46;
    L49:
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r20 = r18.iterator();
    L51:
        if (r20.hasNext() == false) goto L53;
        r19.add(a((JSONObject) ZeusTransformUtils.preCheckCast(r20.next(), JSONObject.class, "com.obric.memorydata.plugin"), r9));
        goto L51
    L53:
        List r21 = (List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.memorydata.plugin");
        if (r11 == false) goto L56;
        C0639c r22 = new C0639c(new b(r21), true);
    L57:
        return r22;
    L56:
        r22 = new C0639c(CollectionsKt.last(r21), true);
        goto L57
    L46:
        if (Intrinsics.areEqual(r10, "targetId") == false) goto L49;
        return new C0639c(((JSONObject) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r13), JSONObject.class, "com.obric.memorydata.plugin")).optString(OaidModel.KEY_ID), true);
    L59:
        throw new EntityNotFoundException("app intent entity already deleted: " + r17.optString("ecaId"));
    L34:
        return new C0639c(r7, false);
    L30:
        return new C0639c(r7, false);
    L5:
        return new C0639c(r7, false);
    }

    private final C0639c a(JSONArray r14, boolean r15, String r16, String r17) {
        JSONArray r1 = new JSONArray();
        int r2 = r14.length();
        int r4 = 0;
        boolean r5 = false;
    L4:
        if (r4 >= r2) goto L19;
        C0639c r7 = a(r14.opt(r4), r15, r16, r17, true);
        Object r8 = r7.a();
        if (ZeusTransformUtils.instanceOf(r8, b.class) == false) goto L11;
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(((b) ZeusTransformUtils.preCheckCast(r8, b.class, "com.obric.memorydata.plugin")).a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r9.hasNext() == false) goto L13;
        r1.put(r9.next());
    L13:
        if (r7.b() == true) goto L17;
        if (r5 == true) goto L17;
        r5 = false;
    L18:
        r4 = r4 + 1;
    L17:
        r5 = true;
        goto L18
    L11:
        r1.put(r8);
        goto L13
    L19:
        if (r5 == false) goto L22;
        return new C0639c(r1, true);
    L22:
        return new C0639c(r14, false);
    }

    private final JSONObject a(Object r3) {
        Object r0 = null;
        if (ZeusTransformUtils.instanceOf(r3, JSONObject.class) == false) goto L7;
        Object r2 = ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.memorydata.plugin");
    L17:
        return (JSONObject) r2;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L20;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L10
        Object r5 = Result.m1421constructorimpl(new JSONObject((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L10
    L13:
        if (Result.m1427isFailureimpl(r5) == true) goto L16;
        r0 = r5;
    L16:
        r2 = ZeusTransformUtils.preCheckCast(r0, JSONObject.class, "com.obric.memorydata.plugin");
    L10:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L13
    L20:
        return null;
    }

    private final JSONObject a(JSONObject r5, String r6) {
        JSONObject r0 = new JSONObject(r5.toString());
        a(r0);
        boolean r4 = f.contains(r6);
        boolean r7 = false;
        if (r4 == false) goto L7;
        String r8 = r0.optString("ecaId");
        Intrinsics.checkNotNullExpressionValue(r8, "optString(...)");
        if (StringsKt.startsWith$default(r8, "$NE_", false, 2, null) == true) goto L7;
        r7 = true;
    L7:
        if (r7 == true) goto L9;
        r0.remove("ecaId");
        r0.remove("ecaid");
        r0.remove("eca_id");
    L9:
        return r0;
    }

    private final void a(JSONArray r6) {
        int r0 = r6.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        Object r2 = r6.opt(r1);
        if (ZeusTransformUtils.instanceOf(r2, JSONObject.class) == false) goto L8;
        a((JSONObject) ZeusTransformUtils.preCheckCast(r2, JSONObject.class, "com.obric.memorydata.plugin"));
    L10:
        r1 = r1 + 1;
        goto L3
    L8:
        if (ZeusTransformUtils.instanceOf(r2, JSONArray.class) == false) goto L10;
        a((JSONArray) ZeusTransformUtils.preCheckCast(r2, JSONArray.class, "com.obric.memorydata.plugin"));
        goto L10
    }

    private final void a(JSONObject r5) {
        a(r5, "createTime", "createTimeStamp");
        a(r5, "lastModifiedTime", "lastModifiedTimeStamp");
        Iterator<String> r0 = r5.keys();
        Intrinsics.checkNotNullExpressionValue(r0, "keys(...)");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(SequencesKt.toList(SequencesKt.asSequence(r0)), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        Object r2 = r5.opt((String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin"));
        if (ZeusTransformUtils.instanceOf(r2, JSONObject.class) == true) goto L7;
        if (ZeusTransformUtils.instanceOf(r2, JSONArray.class) == false) goto L4;
        a((JSONArray) ZeusTransformUtils.preCheckCast(r2, JSONArray.class, "com.obric.memorydata.plugin"));
        goto L4
    L7:
        a((JSONObject) ZeusTransformUtils.preCheckCast(r2, JSONObject.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    private final void a(JSONObject r3, String r4, String r5) {
        Object r2 = r3.opt(r5);
        if (ZeusTransformUtils.instanceOf(r2, Number.class) == false) goto L6;
        Long r6 = Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).longValue());
    L9:
        if (r6 == null) goto L12;
        r3.put(r4, r6.longValue());
        r3.remove(r5);
        return;
    L12:
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L8;
        r6 = StringsKt.toLongOrNull((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin"));
        goto L9
    L8:
        r6 = null;
        goto L9
    }

    private final boolean a(JSONObject r12, boolean r13, String r14, String r15) {
        String r0 = r12.optString("actionName");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L9;
        r14 = r0;
    L9:
        boolean r1 = false;
        if (r13 == true) goto L12;
    L14:
        boolean r16 = false;
    L15:
        Iterator<String> r2 = r12.keys();
        Intrinsics.checkNotNullExpressionValue(r2, "keys(...)");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(SequencesKt.toList(SequencesKt.asSequence(r2)), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L17:
        if (r3.hasNext() == false) goto L27;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r10, EventBody.KEY_VALUE) == true) goto L21;
    L23:
        String r8 = r10;
    L24:
        Object r5 = r12.opt(r10);
        Intrinsics.checkNotNull(r8);
        C0639c r4 = a(r5, r16, r14, r8, false);
        if (r4.b() == false) goto L17;
        r12.put(r10, r4.a());
        r1 = true;
        goto L17
    L21:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L23;
        r8 = r15;
        goto L24
    L27:
        return r1;
    L12:
        if (e.contains(r14) == true) goto L14;
        r16 = true;
        goto L15
    }

    private final List<JSONObject> b(String r8) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        c r2 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r9 = Result.m1421constructorimpl(new JSONObject(r8));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r9) == false) goto L10;
        r9 = null;
    L10:
        JSONObject r10 = (JSONObject) ZeusTransformUtils.preCheckCast(r9, JSONObject.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L13;
        JSONObject r11 = a(r10.opt(Params.CONTENT));
        if (r11 == null) goto L17;
        JSONObject r7 = a(r11.opt("Content"));
        if (r7 == null) goto L21;
        JSONArray r12 = r7.optJSONArray("jobs");
        if (r12 == null) goto L25;
        List r13 = CollectionsKt.createListBuilder();
        int r0 = r12.length();
        int r3 = 0;
    L27:
        if (r3 >= r0) goto L41;
        JSONObject r4 = r12.optJSONObject(r3);
        if (r4 == null) goto L39;
        JSONArray r5 = r4.optJSONArray("actions");
        if (r5 == null) goto L39;
        int r6 = r5.length();
        int r14 = 0;
    L34:
        if (r14 >= r6) goto L39;
        JSONObject r15 = r5.optJSONObject(r14);
        if (r15 == null) goto L38;
        r13.add(r15);
    L38:
        r14 = r14 + 1;
    L39:
        r3 = r3 + 1;
        goto L27
    L41:
        return CollectionsKt.build(r13);
    L25:
        return CollectionsKt.emptyList();
    L21:
        return CollectionsKt.emptyList();
    L17:
        return CollectionsKt.emptyList();
    L13:
        return CollectionsKt.emptyList();
    L5:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final List<JSONObject> b(JSONObject r5) {
        JSONObject r4 = r5.optJSONObject("inputParams");
        if (r4 == null) goto L23;
        JSONObject r6 = r4.optJSONObject("targets");
        if (r6 == null) goto L23;
        Object r7 = r6.opt(EventBody.KEY_VALUE);
        if (r7 == null) goto L23;
        if (ZeusTransformUtils.instanceOf(r7, JSONObject.class) == false) goto L12;
        return CollectionsKt.listOf(r7);
    L12:
        if (ZeusTransformUtils.instanceOf(r7, JSONArray.class) == false) goto L21;
        List r8 = CollectionsKt.createListBuilder();
        int r0 = 0;
        int r1 = ((JSONArray) ZeusTransformUtils.preCheckCast(r7, JSONArray.class, "com.obric.memorydata.plugin")).length();
    L14:
        if (r0 >= r1) goto L28;
        JSONObject r3 = ((JSONArray) ZeusTransformUtils.preCheckCast(r7, JSONArray.class, "com.obric.memorydata.plugin")).optJSONObject(r0);
        if (r3 == null) goto L18;
        r8.add(r3);
    L18:
        r0 = r0 + 1;
        goto L14
    L28:
        return CollectionsKt.build(r8);
    L21:
        return CollectionsKt.emptyList();
    L23:
        return CollectionsKt.emptyList();
    }

    private final boolean c(String r4) {
        return StringsKt.startsWith$default(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString(), "{", false, 2, null);
    }

    private final boolean d(String r3) {
        return d.containsMatchIn((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    public final String a(String r9) {
        Intrinsics.checkNotNullParameter(r9, "payload");
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("$E_", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L18;
        return r9;
    L18:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        c r1 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        Object r2 = Result.m1421constructorimpl(new JSONObject(r9));     // Catch: Throwable -> L7
    L9:
        Throwable r3 = Result.m1424exceptionOrNullimpl(r2);
        if (r3 != null) goto L17;
        JSONObject r4 = (JSONObject) ZeusTransformUtils.preCheckCast(r2, JSONObject.class, "com.obric.memorydata.plugin");
        C0639c r8 = a(r4.opt(Params.CONTENT), true, "", Params.CONTENT, false);
        if (r8.b() == true) goto L14;
        return r9;
    L14:
        r4.put(Params.CONTENT, r8.a());
        String r10 = r4.toString();
        Intrinsics.checkNotNullExpressionValue(r10, "toString(...)");
        return r10;
    L17:
        throw new EntityResolutionException("app intent command containing an ECA reference must be valid JSON", r3);
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public final String a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "rawResult");
        return this.f11808b.a(r2, r3);
    }

    public final void b(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "preparedPayload");
        Intrinsics.checkNotNullParameter(r8, "rawResult");
        List<? extends JSONObject> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(b(r7), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r9.hasNext() == false) goto L25;
        JSONObject r1 = (JSONObject) ZeusTransformUtils.preCheckCast(r9.next(), JSONObject.class, "com.obric.memorydata.plugin");
        String r3 = r1.optString("actionName");
        if (r3 == null) goto L4;
        int r4 = r3.hashCode();
        if (r4 != (-1665258020)) goto L10;
        if (r3.equals("Phone_Delete") == false) goto L4;
    L24:
        CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(b(r1), Iterable.class, "com.obric.memorydata.plugin"));
        goto L4
    L10:
        if (r4 != (-444170667)) goto L12;
        if (r3.equals("Clock_DeleteCountdown") == false) goto L4;
        CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(this.f11808b.c(r8), Iterable.class, "com.obric.memorydata.plugin"));
        goto L4
    L12:
        if (r4 != 1138119447) goto L4;
        if (r3.equals("Contacts_Delete") == true) goto L24;
    L25:
        this.f11808b.a(r0);
    }
}
