package com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper;

import android.animation.ValueAnimator;
import com.ss.android.lark.scaffold.LogicComponent;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboardwrapper/KeyboardWrapperComponent;", "Lcom/ss/android/lark/scaffold/LogicComponent;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboardwrapper/IKeyboardWrapperComponent;", "<init>", "()V", "keyboardWrapper", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboardwrapper/KeyboardWrapper;", "getKeyboardWrapper", "()Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboardwrapper/KeyboardWrapper;", "keyboardWrapper$delegate", "Lkotlin/Lazy;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboardwrapper/IKeyboardWrapper;", "provideWidgetExport", BuildConfig.FLAVOR, "Ljava/lang/Class;", "Lcom/ss/android/lark/framework/larkwidget/WidgetExport;", "onDestroy", BuildConfig.FLAVOR, "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardWrapperComponent extends LogicComponent implements IKeyboardWrapperComponent {
    public final Lazy i;

    public final Map<Class<? extends com.ss.android.lark.framework.larkwidget.c>, com.ss.android.lark.framework.larkwidget.c> z0() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(IKeyboardWrapperComponent.class, this), TuplesKt.to(IKeyboardWrapper.class, (KeyboardWrapper) this.i.getValue())});
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.IKeyboardWrapperComponent
    public final IKeyboardWrapper wA() {
        return (KeyboardWrapper) this.i.getValue();
    }

    public KeyboardWrapperComponent() {
        this.i = LazyKt.lazy(LazyThreadSafetyMode.NONE, new KeyboardWrapperComponent$keyboardWrapper$2(this));
    }

    public final void onDestroy() {
        super/*com.ss.android.lark.framework.larkwidget.Widget*/.onDestroy();
        c r0 = (c) ((KeyboardWrapper) this.i.getValue()).g.getValue();
        ValueAnimator r1 = r0.d;
        if (r1 == null) goto L5;
        r1.cancel();
    L5:
        ValueAnimator r2 = r0.e;
        if (r2 == null) goto L8;
        r2.cancel();
    L8:
        r0.d = null;
        r0.e = null;
    }
}
