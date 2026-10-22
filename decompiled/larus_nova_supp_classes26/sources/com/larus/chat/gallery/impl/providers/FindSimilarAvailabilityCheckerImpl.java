package com.larus.chat.gallery.impl.providers;

import com.google.gson.annotations.SerializedName;
import com.larus.chat.gallery.api.IFindSimilarAvailabilityChecker;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0002\t\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/larus/chat/gallery/impl/providers/FindSimilarAvailabilityCheckerImpl;", "Lcom/larus/chat/gallery/api/IFindSimilarAvailabilityChecker;", "<init>", "()V", "checkAvailability", "Lcom/larus/chat/gallery/api/FindSimilarAvailability;", "imageUri", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "FindSimilarResp", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FindSimilarAvailabilityCheckerImpl implements IFindSimilarAvailabilityChecker {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003JJ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/larus/chat/gallery/impl/providers/FindSimilarAvailabilityCheckerImpl$FindSimilarResp;", "", "findButtonAvailable", "", "findEntranceText", "", "findSendText", "artifactType", "bizPayload", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFindButtonAvailable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFindEntranceText", "()Ljava/lang/String;", "getFindSendText", "getArtifactType", "getBizPayload", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/chat/gallery/impl/providers/FindSimilarAvailabilityCheckerImpl$FindSimilarResp;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FindSimilarResp {

        @SerializedName("artifact_type")
        private final String artifactType;

        @SerializedName("biz_payload")
        private final String bizPayload;

        @SerializedName("find_button_available")
        private final Boolean findButtonAvailable;

        @SerializedName("find_entrance_text")
        private final String findEntranceText;

        @SerializedName("find_send_text")
        private final String findSendText;

        public FindSimilarResp() {
            this(null, null, null, null, null, 31, null);
        }

        public static /* synthetic */ FindSimilarResp copy$default(FindSimilarResp r3, Boolean r4, String r5, String r6, String r7, String r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.findButtonAvailable;
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.findEntranceText;
        L8:
            String r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.findSendText;
        L11:
            String r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.artifactType;
        L14:
            String r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = r3.bizPayload;
        L17:
            Boolean r12 = r4;
            return r3.copy(r12, r11, r0, r1, r8);
        }

        public final Boolean component1() {
            return this.findButtonAvailable;
        }

        public final String component2() {
            return this.findEntranceText;
        }

        public final String component3() {
            return this.findSendText;
        }

        public final String component4() {
            return this.artifactType;
        }

        public final String component5() {
            return this.bizPayload;
        }

        public final FindSimilarResp copy(Boolean r8, String r9, String r10, String r11, String r12) {
            return new FindSimilarResp(r8, r9, r10, r11, r12);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof FindSimilarResp) == true) goto L8;
            return false;
        L8:
            FindSimilarResp r6 = (FindSimilarResp) r5;
            if (Intrinsics.areEqual(this.findButtonAvailable, r6.findButtonAvailable) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.findEntranceText, r6.findEntranceText) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.findSendText, r6.findSendText) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.artifactType, r6.artifactType) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.bizPayload, r6.bizPayload) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            Boolean r0 = this.findButtonAvailable;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.findEntranceText;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.findSendText;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.artifactType;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.bizPayload;
            if (r13 == null) goto L23;
            r1 = r13.hashCode();
        L23:
            return r12 + r1;
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "FindSimilarResp(findButtonAvailable=" + this.findButtonAvailable + ", findEntranceText=" + this.findEntranceText + ", findSendText=" + this.findSendText + ", artifactType=" + this.artifactType + ", bizPayload=" + this.bizPayload + ')';
        }

        public final String getArtifactType() {
            return this.artifactType;
        }

        public final String getBizPayload() {
            return this.bizPayload;
        }

        public final Boolean getFindButtonAvailable() {
            return this.findButtonAvailable;
        }

        public final String getFindEntranceText() {
            return this.findEntranceText;
        }

        public final String getFindSendText() {
            return this.findSendText;
        }

        public FindSimilarResp(Boolean r1, String r2, String r3, String r4, String r5) {
            this.findButtonAvailable = r1;
            this.findEntranceText = r2;
            this.findSendText = r3;
            this.artifactType = r4;
            this.bizPayload = r5;
        }

        public /* synthetic */ FindSimilarResp(Boolean r4, String r5, String r6, String r7, String r8, int r9, DefaultConstructorMarker r10) {
            if ((r9 & 1) == 0) goto L5;
            r4 = Boolean.FALSE;
        L5:
            String r0 = "";
            if ((r9 & 2) == 0) goto L8;
            String r11 = "";
        L10:
            if ((r9 & 4) == 0) goto L12;
            String r1 = "";
        L14:
            if ((r9 & 8) == 0) goto L16;
            String r2 = "";
        L18:
            if ((r9 & 16) != 0) goto L21;
            r0 = r8;
        L21:
            this(r4, r11, r1, r2, r0);
            return;
        L16:
            r2 = r7;
            goto L18
        L12:
            r1 = r6;
            goto L14
        L8:
            r11 = r5;
            goto L10
        }
    }

    public static final class a {
    }

    static {
    }

    public FindSimilarAvailabilityCheckerImpl() {
    }

    @Override // com.larus.chat.gallery.api.IFindSimilarAvailabilityChecker
    public final Object a(String r18, Continuation<? super com.larus.chat.gallery.api.h> r19) {
        String r0 = r18;
        if ((r19 instanceof FindSimilarAvailabilityCheckerImpl$checkAvailability$1) == false) goto L7;
        FindSimilarAvailabilityCheckerImpl$checkAvailability$1 r2 = (FindSimilarAvailabilityCheckerImpl$checkAvailability$1) r19;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        FindSimilarAvailabilityCheckerImpl$checkAvailability$1 r14 = r2;
        Object r1 = r14.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r14.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        r0 = (String) r14.L$0;
        ResultKt.throwOnFailure(r1);
        Object r6 = r1;
    L17:
        y r7 = (com.larus.network.http.a) r6;
        if ((r7 instanceof y) == false) goto L55;
        FLogger.a.i("FindSimilarAvailability", "checkAvailability Success " + r0);
        y r8 = r7;
        FindSimilarResp r9 = (FindSimilarResp) ((com.larus.network.http.a) r8).b;
        if (r9 == null) goto L24;
        Boolean r10 = r9.getFindButtonAvailable();
        if (r10 == null) goto L24;
        boolean r11 = r10.booleanValue();
    L25:
        FindSimilarResp r12 = (FindSimilarResp) ((com.larus.network.http.a) r8).b;
        if (r12 == null) goto L31;
        String r13 = r12.getFindEntranceText();
        if (r13 == null) goto L31;
        String r15 = r13;
    L32:
        FindSimilarResp r16 = (FindSimilarResp) ((com.larus.network.http.a) r8).b;
        if (r16 == null) goto L38;
        String r17 = r16.getFindSendText();
        if (r17 == null) goto L38;
        String r20 = r17;
    L39:
        FindSimilarResp r21 = (FindSimilarResp) ((com.larus.network.http.a) r8).b;
        if (r21 == null) goto L45;
        String r22 = r21.getArtifactType();
        if (r22 == null) goto L45;
        String r23 = r22;
    L46:
        FindSimilarResp r24 = (FindSimilarResp) ((com.larus.network.http.a) r8).b;
        if (r24 == null) goto L52;
        String r25 = r24.getBizPayload();
        if (r25 == null) goto L52;
        String r110 = r25;
    L60:
        return new com.larus.chat.gallery.api.h(r11, r15, r20, r23, r110);
    L52:
        r110 = "";
    L45:
        r23 = "";
    L38:
        r20 = "";
    L31:
        r15 = "";
    L24:
        r11 = false;
        goto L25
    L55:
        if ((r7 instanceof com.larus.network.http.f) == true) goto L58;
        FLogger.a.w(r15, "checkAvailability Null " + r0);
        return com.larus.chat.gallery.api.h.f;
    L58:
        FLogger r26 = FLogger.a;
        StringBuilder r27 = new StringBuilder("checkAvailability Fail ");
        r27.append(r0);
        r27.append(", error=");
        com.larus.network.http.f r28 = (com.larus.network.http.f) r7;
        r27.append(r28.d);
        r26.w(r15, r27.toString());
        throw r28.d;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        FLogger.a.i("FindSimilarAvailability", "checkAvailability stub, imageUri=" + r0);
        JSONObject r29 = new JSONObject();
        r29.put("image_url", r0);
        Unit r30 = Unit.INSTANCE;
        r14.L$0 = r0;
        r14.label = 1;
        r6 = HttpExtKt.k("Ecommerce", FindSimilarResp.class, "/alice/e_commerce/image_intent_recognize", r29, null, null, false, null, null, null, r14, 1008);
        if (r6 != r4) goto L17;
        return r4;
    L7:
        r2 = new FindSimilarAvailabilityCheckerImpl$checkAvailability$1(this, r19);
        goto L8
    }
}
