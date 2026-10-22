package com.ss.android.lark.flow.chat.page.flow.plugin.tip;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/storage/kv/repo/KVRepo;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class FlowMentionDoubaoTipPlugin$hintLocalStore$2 extends Lambda implements Function0<KVRepo> {
    public static final FlowMentionDoubaoTipPlugin$hintLocalStore$2 INSTANCE = null;

    static {
        INSTANCE = new FlowMentionDoubaoTipPlugin$hintLocalStore$2();
    }

    public FlowMentionDoubaoTipPlugin$hintLocalStore$2() {
        super(0);
    }

    public final KVRepo invoke() {
        return LarkKVStorage.p(a.g, "onboarding_hint", true);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m143invoke() {
        return invoke();
    }
}
