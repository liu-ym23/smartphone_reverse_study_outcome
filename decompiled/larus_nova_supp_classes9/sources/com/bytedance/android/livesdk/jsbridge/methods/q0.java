package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.annotations.SerializedName;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q0 extends com.bytedance.ies.web.jsbridge2.f<b, JSONObject> {
    public final c a;
    public final String b;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001a\u0010\u0018\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/q0$b;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "groupOwnerId", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "userId", "h", "conversationId", "b", "conversationShortId", "c", BuildConfig.FLAVOR, "sourceType", "Ljava/lang/Integer;", "g", "()Ljava/lang/Integer;", "enterFrom", "d", "url", "getUrl", "groupEntryLimit", "e", "checkParticipant", "I", "a", "()I", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("check_participant")
        private final int checkParticipant;

        @SerializedName("conversation_id")
        private final String conversationId;

        @SerializedName("conversation_short_id")
        private final String conversationShortId;

        @SerializedName("enter_from")
        private final String enterFrom;

        @SerializedName("group_entry_limit")
        private final String groupEntryLimit;

        @SerializedName("group_owner_id")
        private final String groupOwnerId;

        @SerializedName("source_type")
        private final Integer sourceType;

        @SerializedName("back_url")
        private final String url;

        @SerializedName("user_id")
        private final String userId;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L24;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.groupOwnerId, r4.groupOwnerId) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.userId, r4.userId) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.conversationId, r4.conversationId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.conversationShortId, r4.conversationShortId) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.sourceType, r4.sourceType) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.enterFrom, r4.enterFrom) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.url, r4.url) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.groupEntryLimit, r4.groupEntryLimit) == true) goto L22;
            return false;
        L22:
            if (this.checkParticipant == r4.checkParticipant) goto L37;
            return false;
        L37:
            return true;
        L24:
            return false;
        }

        public final int hashCode() {
            String r0 = this.groupOwnerId;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.userId;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.conversationId;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.conversationShortId;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r13 = (r9 + r11) * 31;
            Integer r14 = this.sourceType;
            if (r14 == null) goto L21;
            int r15 = r14.hashCode();
        L22:
            int r16 = (r13 + r15) * 31;
            String r17 = this.enterFrom;
            if (r17 == null) goto L25;
            int r18 = r17.hashCode();
        L26:
            int r19 = (r16 + r18) * 31;
            String r20 = this.url;
            if (r20 == null) goto L29;
            int r21 = r20.hashCode();
        L30:
            int r23 = (r19 + r21) * 31;
            String r24 = this.groupEntryLimit;
            if (r24 == null) goto L34;
            r1 = r24.hashCode();
        L34:
            return ((r23 + r1) * 31) + this.checkParticipant;
        L29:
            r21 = 0;
            goto L30
        L25:
            r18 = 0;
            goto L26
        L21:
            r15 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Params(groupOwnerId=" + this.groupOwnerId + ", userId=" + this.userId + ", conversationId=" + this.conversationId + ", conversationShortId=" + this.conversationShortId + ", sourceType=" + this.sourceType + ", enterFrom=" + this.enterFrom + ", url=" + this.url + ", groupEntryLimit=" + this.groupEntryLimit + ", checkParticipant=" + this.checkParticipant + ")";
        }

        public final int a() {
            return this.checkParticipant;
        }

        public final String b() {
            return this.conversationId;
        }

        public final String c() {
            return this.conversationShortId;
        }

        public final String d() {
            return this.enterFrom;
        }

        public final String e() {
            return this.groupEntryLimit;
        }

        public final String f() {
            return this.groupOwnerId;
        }

        public final Integer g() {
            return this.sourceType;
        }

        public final String h() {
            return this.userId;
        }
    }

    public static final class c implements IHostAction.IMConversationCallback {
        public final /* synthetic */ q0 a;

        public c(q0 r1) {
            this.a = r1;
        }

        public final void onFailure(JSONObject r2) {
            this.a.finishWithResult(r2);
        }

        public final void onSuccess(JSONObject r2) {
            this.a.finishWithResult(r2);
        }
    }

    static {
    }

    public final void onTerminate() {
    }

    public q0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "method");
        this.b = r2;
        this.a = new c(this);
    }

    public final void invoke(Object r11, CallContext r13) {
        b r14 = (b) r11;
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r13, "context");
        String r0 = r14.f();
        if (r0 == null) goto L5;
        Long r5 = Long.valueOf(CastLongProtector.parseLong(r0));
    L6:
        String r1 = r14.h();
        if (r1 == null) goto L9;
        Long r6 = Long.valueOf(CastLongProtector.parseLong(r1));
    L10:
        String r3 = r14.b();
        String r4 = r14.c();
        Integer r2 = r14.g();
        if (r2 == null) goto L13;
        int r7 = r2.intValue();
    L14:
        String r8 = r14.d();
        String r9 = BuildConfig.FLAVOR;
        if (r8 != null) goto L17;
        r8 = BuildConfig.FLAVOR;
    L17:
        String r10 = r14.e();
        if (r10 == null) goto L21;
        r9 = r10;
    L21:
        int r15 = r14.a();
        String r16 = this.b;
        switch(r16.hashCode()) {
            case -1946912619: goto L34;
            case -1685397245: goto L31;
            case -137931493: goto L28;
            case 1835314847: goto L25;
            default: goto L44;
        };
    L44:
        return;
    L25:
        if (r16.equals("enterFansGroupChat") == false) goto L37;
        jc1.k.n(IHostAction.class).startChat(r13.getContext(), r3, r15, this.a);
        return;
    L37:
        return;
    L28:
        if (r16.equals("openFansGroupSetting") == false) goto L39;
        xs2.b.a().post(new zg1.b(r3, r8, null, new WeakReference(r13.getContext())));
        return;
    L39:
        return;
    L31:
        if (r16.equals("createFansGroup") == false) goto L41;
        jc1.k.n(IHostAction.class).createGroupConversationForFans(CollectionsKt.arrayListOf(new Long[]{r5}), r9, this.a);
        return;
    L41:
        return;
    L34:
        if (r16.equals("joinFansGroup") == false) goto L43;
        jc1.k.n(IHostAction.class).addGroupMemberListForFans(r3, r4, r5, r6, r7, this.a);
        return;
    L43:
        return;
    L13:
        r7 = 7;
        goto L14
    L9:
        r6 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }
}
