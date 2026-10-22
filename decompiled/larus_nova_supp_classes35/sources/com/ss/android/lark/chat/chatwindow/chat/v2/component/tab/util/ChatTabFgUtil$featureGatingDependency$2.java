package com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.util;

import com.ss.android.lark.chat.core.api.ChatCoreModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import w4b.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/chat/core/dependency/FeatureGatingDependency;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ChatTabFgUtil$featureGatingDependency$2 extends Lambda implements Function0<l> {
    public static final ChatTabFgUtil$featureGatingDependency$2 INSTANCE = null;

    static {
        INSTANCE = new ChatTabFgUtil$featureGatingDependency$2();
    }

    public ChatTabFgUtil$featureGatingDependency$2() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final l m429invoke() {
        return ChatCoreModule.a().getFeatureGatingDependency();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m429invoke();
    }
}
