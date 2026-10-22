package com.ss.android.lark.chat.preview.memberlist;

import com.bytedance.lark.pb.url.v1.PullUrlPreviewChattersListRequest;
import com.bytedance.lark.pb.url.v1.PullUrlPreviewChattersListResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkCall;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MemberListService {
    public static final MemberListService a = null;

    public interface a {
        @SdkCall(3839)
        RucketJob<PullUrlPreviewChattersListResponse> loadMemberList(PullUrlPreviewChattersListRequest r1);
    }

    public static abstract class b<T> {

        public static final class a extends b {
            public final ErrorResult a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Error(error=" + this.a + ')';
            }

            public a(ErrorResult r2) {
                Intrinsics.checkNotNullParameter(r2, Keys.API_RETURN_KEY_ERROR);
                this.a = r2;
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.chat.preview.memberlist.MemberListService$b$b, reason: collision with other inner class name */
        public static final class C0110b<T> extends b<T> {
            public final T a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof C0110b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((C0110b) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                T r0 = this.a;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0.hashCode();
            }

            public final String toString() {
                return "Success(data=" + this.a + ')';
            }

            public C0110b(T r1) {
                this.a = r1;
            }
        }

        public b() {
        }
    }

    static {
        a = new MemberListService();
    }

    public MemberListService() {
    }

    public final Object a(String r5, String r6, String r7, Continuation<? super b<PullUrlPreviewChattersListResponse>> r8) {
        if ((r8 instanceof MemberListService$loadMemberList$1) == false) goto L7;
        MemberListService$loadMemberList$1 r0 = (MemberListService$loadMemberList$1) r8;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L17:
        com.larksuite.rucket.job.base.b.c r10 = (com.larksuite.rucket.job.base.b) r9;
        if ((r10 instanceof com.larksuite.rucket.job.base.b.c) == false) goto L21;
        return new b.C0110b(r10.b);
    L21:
        if ((r10 instanceof com.larksuite.rucket.job.base.b.b) == false) goto L25;
        return new b.a(((com.larksuite.rucket.job.base.b.b) r10).b);
    L25:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        PullUrlPreviewChattersListRequest.Builder r11 = new PullUrlPreviewChattersListRequest.Builder();
        r11.preview_id(r5);
        r11.component_id(r6);
        r11.next_token(r7);
        PullUrlPreviewChattersListRequest r12 = r11.build();
        a r13 = (a) b38.b.a.create(a.class);
        Intrinsics.checkNotNull(r12);
        RucketJob<PullUrlPreviewChattersListResponse> r14 = r13.loadMemberList(r12);
        r0.label = 1;
        r9 = r14.awaitGet(r0);
        if (r9 != r2) goto L17;
        return r2;
    L7:
        r0 = new MemberListService$loadMemberList$1(this, r8);
        goto L8
    }
}
