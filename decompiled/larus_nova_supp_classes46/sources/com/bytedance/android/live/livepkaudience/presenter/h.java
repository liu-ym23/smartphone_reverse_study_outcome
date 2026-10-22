package com.bytedance.android.live.livepkaudience.presenter;

import com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceInviteListContract$View;
import com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceInviteListFragment$onViewCreated$$inlined$apply$lambda$1;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livehostapi.business.IMiddlewareHostSocial;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ g a;
    public final /* synthetic */ List b;
    public final /* synthetic */ Function2 c;
    public final /* synthetic */ IRoom d;

    public h(g r1, List r2, BasePkAudienceInviteListFragment$onViewCreated$$inlined$apply$lambda$1.AnonymousClass1.a.C0113a r3, IRoom r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r4) {
        final Set r5 = SequencesKt.toSet(SequencesKt.map(CollectionsKt.asSequence(((bl0.c) ((Response) r4).data).invitedUidList), PkAudienceInviteListPresenter$inviteFriends$4$uidSet$1.INSTANCE));
        List<? extends IMiddlewareHostSocial.InviteFriendsConfig.Friend> r6 = SequencesKt.toList(SequencesKt.onEach(SequencesKt.filter(CollectionsKt.asSequence(this.b), new PkAudienceInviteListPresenter$inviteFriends$4$filteredList$1(r5)), PkAudienceInviteListPresenter$inviteFriends$4$filteredList$2.INSTANCE));
        this.c.invoke(this.b, this.d);
        BasePkAudienceInviteListContract$View r0 = (BasePkAudienceInviteListContract$View) this.a.b;
        if (r0 == null) goto L6;
        r0.Z90(r6);
        return;
    }
}
