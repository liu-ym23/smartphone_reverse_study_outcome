package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text;

import com.ss.android.lark.chat.core.api.ChatCoreModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import w4b.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/chat/core/dependency/SettingDependency;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class CharSequenceRender$mNtpService$2 extends Lambda implements Function0<d0> {
    public static final CharSequenceRender$mNtpService$2 INSTANCE = null;

    static {
        INSTANCE = new CharSequenceRender$mNtpService$2();
    }

    public CharSequenceRender$mNtpService$2() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final d0 m217invoke() {
        return ChatCoreModule.a().getSettingDependency();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m217invoke();
    }
}
