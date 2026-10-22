package com.ss.android.lark.chat.repository.impl;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.CreateDraftRequest;
import com.bytedance.lark.pb.im.v1.CreateDraftResponse;
import com.bytedance.lark.pb.im.v1.CreateOrDeleteChatLastDraftIdRequest;
import com.bytedance.lark.pb.im.v1.CreateOrDeleteChatLastDraftIdResponse;
import com.bytedance.lark.pb.im.v1.DeleteDraftRequest;
import com.bytedance.lark.pb.im.v1.DeleteDraftResponse;
import com.bytedance.lark.pb.im.v1.FetchChatInputDraftRequest;
import com.bytedance.lark.pb.im.v1.FetchChatInputDraftResponse;
import com.bytedance.lark.pb.im.v1.FetchMessageReplyDraftRequest;
import com.bytedance.lark.pb.im.v1.FetchMessageReplyDraftResponse;
import com.bytedance.lark.pb.im.v1.GetAllDraftsRequest;
import com.bytedance.lark.pb.im.v1.GetAllDraftsResponse;
import com.bytedance.lark.pb.im.v1.GetDraftsRequest;
import com.bytedance.lark.pb.im.v1.GetDraftsResponse;
import com.bytedance.lark.pb.im.v1.PutChatOrThreadDraftsUpdateRequest;
import com.bytedance.lark.pb.im.v1.PutChatOrThreadDraftsUpdateResponse;
import com.bytedance.lark.rustclient.api.d;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.p;
import com.bytedance.lark.rustclient.api.t;
import com.bytedance.lark.rustclient.api.x;
import com.ss.android.lark.chat.service.impl.k;
import com.ss.android.lark.chat.service.impl.m;
import com.ss.android.lark.chat.service.impl.n;
import com.ss.android.lark.chat.service.impl.q;
import com.ss.android.lark.dto.draft.Draft;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class DraftRepositoryV2 implements l6b.a {
    public final l a;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public static final b<T> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r2) {
            x r3 = (x) r2;
            Log.i("DraftRepositoryV2", "call SDK Command=PUT_CHAT_OR_THREAD_DRAFTS_UPDATE async success");
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            Log.e("DraftRepositoryV2", "call SDK Command=PUT_CHAT_OR_THREAD_DRAFTS_UPDATE async failed, error=" + ((Throwable) r3).getMessage());
        }
    }

    static {
    }

    @Inject
    public DraftRepositoryV2(l r2) {
        Intrinsics.checkNotNullParameter(r2, "userClient");
        this.a = r2;
    }

    @Override // l6b.a
    public final void b(DeleteDraftRequest.Builder r11) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        d r0 = new d(r11, DeleteDraftResponse.ADAPTER, Command.DELETE_DRAFT, null, null, null, null, 248);
        t.d(this.a.h(r0).execute());
    }

    @Override // l6b.a
    public final void c(PutChatOrThreadDraftsUpdateRequest.Builder r11) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        d r0 = new d(r11, PutChatOrThreadDraftsUpdateResponse.ADAPTER, Command.PUT_CHAT_OR_THREAD_DRAFTS_UPDATE, null, null, null, null, 248);
        t.b(this.a.h(r0).a()).subscribe(b.a, c.a);
    }

    @Override // l6b.a
    public final Map<String, List<Draft>> f(final Function1<? super GetAllDraftsResponse, ? extends Map<String, ? extends List<? extends Draft>>> r11) {
        Intrinsics.checkNotNullParameter(r11, "respMap");
        d r0 = new d(new GetAllDraftsRequest.Builder(), GetAllDraftsResponse.ADAPTER, Command.GET_ALL_DRAFTS, null, null, null, null, 248);
        Map<String, List<Draft>> r12 = (Map) t.c(t.e(this.a.h(r0).execute(), new DraftRepositoryV2$getAllDrafts$1(r11)), null);
        if (r12 == null) goto L5;
        return r12;
    L5:
        return MapsKt.emptyMap();
    }

    @Override // l6b.a
    public final void h(CreateOrDeleteChatLastDraftIdRequest.Builder r11) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        d r0 = new d(r11, CreateOrDeleteChatLastDraftIdResponse.ADAPTER, Command.CREATE_OR_DELETE_CHAT_LAST_DRAFT_ID, null, null, null, null, 248);
        t.d(this.a.h(r0).execute());
    }

    @Override // l6b.a
    public final Draft a(FetchMessageReplyDraftRequest.Builder r11, final q r12) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        Intrinsics.checkNotNullParameter(r12, "respMap");
        d r0 = new d(r11, FetchMessageReplyDraftResponse.ADAPTER, Command.FETCH_MESSAGE_REPLY_DRAFT, null, null, null, null, 248);
        return (Draft) t.c(t.e(this.a.h(r0).execute(), new DraftRepositoryV2$fetchMessageReplyDraft$1(r12)), null);
    }

    @Override // l6b.a
    public final Draft e(FetchChatInputDraftRequest.Builder r11, final n r12) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        Intrinsics.checkNotNullParameter(r12, "respMap");
        d r0 = new d(r11, FetchChatInputDraftResponse.ADAPTER, Command.FETCH_CHAT_INPUT_DRAFT, null, null, null, null, 248);
        return (Draft) t.c(t.e(this.a.h(r0).execute(), new DraftRepositoryV2$fetchChatInputDraft$1(r12)), null);
    }

    @Override // l6b.a
    public final Map g(GetDraftsRequest.Builder r11, final k r12) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        Intrinsics.checkNotNullParameter(r12, "respMap");
        d r0 = new d(r11, GetDraftsResponse.ADAPTER, Command.GET_DRAFTS, null, null, null, null, 248);
        Map r13 = (Map) t.c(t.e(this.a.h(r0).execute(), new DraftRepositoryV2$getDrafts$1(r12)), null);
        if (r13 == null) goto L5;
        return r13;
    L5:
        return MapsKt.emptyMap();
    }

    @Override // l6b.a
    public final String d(CreateDraftRequest.Builder r10, com.ss.android.lark.chat.service.impl.l r11, m r12) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        Intrinsics.checkNotNullParameter(r11, "respMap");
        Intrinsics.checkNotNullParameter(r12, "onError");
        d r13 = new d(r10, CreateDraftResponse.ADAPTER, Command.CREATE_DRAFT, null, null, null, null, 248);
        x r14 = this.a.h(r13).execute();
        if ((r14 instanceof x) == false) goto L6;
        return ((CreateDraftResponse) r14.c).draft_id;
    L6:
        if ((r14 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L10;
        r12.invoke(p.a(((com.bytedance.lark.rustclient.api.c) r14).c));
        return null;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
