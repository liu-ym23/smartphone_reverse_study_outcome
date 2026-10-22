package com.larus.av_call.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u001f\u0010\u000e\u001a\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\u0002\b\u0013J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/av_call/view/RealtimeCallSuggestView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "delegate", "Lcom/larus/av_call/view/SuggestAdapterDelegate;", "", "getDelegate", "updateStyle", "", "config", "Lkotlin/Function1;", "Landroid/widget/TextView;", "Lkotlin/ExtensionFunctionType;", "initAndGetDelegate", "av-call_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class RealtimeCallSuggestView extends FrameLayout {
    public static final /* synthetic */ int b = 0;
    public o<String> a;

    public RealtimeCallSuggestView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RealtimeCallSuggestView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.av_call.view.f] */
    public final o<String> getDelegate() {
        o<String> r0 = this.a;
        if (r0 != null) goto L13;
        final TextSwitcher r1 = (TextSwitcher) findViewById(2131387705);
        final Ref.ObjectRef r2 = new Ref.ObjectRef();
        r2.element = "";
        final Ref.IntRef r3 = new Ref.IntRef();
        r3.element = -1;
        final Ref.BooleanRef r4 = new Ref.BooleanRef();
        r4.element = true;
        o<String> r5 = new o(new f(r1, r2, r3, r4));
        this.a = r5;
        final n r6 = r5.h;
        r1.setFactory(new g(r6, r1));
        Context r7 = r1.getContext();
        r6.getClass();
        r1.setInAnimation(r7, 2130772383);
        r1.setOutAnimation(r1.getContext(), 2130772386);
        View r8 = findViewById(2131367728);
        if (r8 == null) goto L8;
        com.larus.utils.e1.d(r8, new h(r6, r2, r3));
    L8:
        o<String> r9 = this.a;
        if (r9 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("delegate");
        return null;
    L12:
        return r9;
    L13:
        return r0;
    }

    public final void a(Function1<? super TextView, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        r2.invoke(findViewById(2131387706));
    }

    public RealtimeCallSuggestView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        FrameLayout.inflate(r2, 2131562919, this);
    }

    public /* synthetic */ RealtimeCallSuggestView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
