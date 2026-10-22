package com.larus.doc.impl.component;

import com.larus.dora.api.protocol.FlowProtocolAbility;
import com.larus.im.bean.bot.BotModel;
import com.larus.ui.arch.component.external.api.Component;
import j39.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0014\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\nH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/doc/impl/component/DocConversationComponent;", "Lcom/larus/ui/arch/component/external/api/Component;", "Lcom/larus/doc/impl/component/IDocConversationAbility;", "<init>", "()V", "docConv", "Lcom/larus/im/bean/conversation/Conversation;", "docBot", "Lcom/larus/im/bean/bot/BotModel;", "scene", "", "onAttach", "", "saveConv", FlowProtocolAbility.FEATURE_CONVERSATION, "saveBot", "bot", "getCurConv", "onFragmentViewDestroyed", "getCurBot", "saveScene", "getCurScene", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocConversationComponent extends Component implements a {
    public e l;
    public BotModel m;
    public String n;

    public final void A2() {
        this.l = null;
        this.m = null;
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, a.class);
    }

    public DocConversationComponent() {
    }

    @Override // j39.a
    public final BotModel P4() {
        return this.m;
    }

    @Override // j39.a
    public final String getCurScene() {
        return this.n;
    }

    @Override // j39.a
    public final e p1() {
        return this.l;
    }

    @Override // j39.a
    public final void P1(e r1) {
        this.l = r1;
    }

    @Override // j39.a
    public final void a5(String r1) {
        this.n = r1;
    }

    @Override // j39.a
    public final void e1(BotModel r1) {
        this.m = r1;
    }
}
