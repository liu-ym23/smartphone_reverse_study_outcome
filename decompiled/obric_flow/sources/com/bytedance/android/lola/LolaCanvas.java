package com.bytedance.android.lola;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ies.web.jsbridge2.p;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.f0;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import q4.a;
import q4.c;
import r4.d;
import s4.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/lola/LolaCanvas;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/view/View;", "Lcom/lynx/react/bridge/ReadableMap;", "data", "Lcom/lynx/react/bridge/Callback;", "callback", "", "measureText", "(Lcom/lynx/react/bridge/ReadableMap;Lcom/lynx/react/bridge/Callback;)V", "flush", "(Lcom/lynx/react/bridge/ReadableMap;)V", "append", "lola-canvas_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LolaCanvas extends LynxUI<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f3508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f3509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f3510c;

    public LolaCanvas(b0 r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, null);
        this.f3510c = new Paint();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @f0
    public final void append(ReadableMap r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        Object r10 = ((HashMap) r5).get("data");
        d r11 = this.f3508a;
        if (r11 == null) goto L8;
        if (r10 == null) goto L7;
        r11.b((List) r10, true);
        goto L8
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }>");
    L8:
        a r12 = this.f3509b;
        if (r12 == null) goto L12;
        r12.invalidate();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f3508a = new d();
        a r10 = new a(r5);
        this.f3509b = r10;
        Intrinsics.checkNotNull(r10);
        r10.setCommandProvider(this.f3508a);
        d r11 = this.f3508a;
        Intrinsics.checkNotNull(r11);
        a r12 = this.f3509b;
        Intrinsics.checkNotNull(r12);
        c r13 = r12.getDrawContext().d;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r13, "dataManager");
        r11.d = r13;
        a r14 = this.f3509b;
        Intrinsics.checkNotNull(r14);
        return r14;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @f0
    public final void flush(ReadableMap r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        Object r10 = ((HashMap) r5).get("data");
        d r11 = this.f3508a;
        if (r11 == null) goto L8;
        if (r10 == null) goto L7;
        r11.b((List) r10, false);
        goto L8
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }>");
    L8:
        a r12 = this.f3509b;
        if (r12 == null) goto L12;
        r12.invalidate();
        return;
    }

    @f0
    public final void measureText(ReadableMap r5, Callback r10) {
        Intrinsics.checkNotNullParameter(r5, "data");
        Intrinsics.checkNotNullParameter(r10, "callback");
        String r11 = r5.getString(MessageIndication.CONTENT_TYPE_TEXT);
        String r12 = r5.getString("fontStyle");
        if (r12.length() <= 0) goto L13;
        HashMap r13 = b.f21815a;
        p r14 = dn.a.H(r12);
        Float r15 = (Float) r14.e;
        if (r15 == null) goto L7;
        float r16 = r15.floatValue();
    L8:
        String r17 = (String) r14.f6304c;
        String r18 = (String) r14.f6303b;
        Integer r19 = (Integer) r14.d;
        if (r19 == null) goto L11;
        int r20 = r19.intValue();
    L12:
        Typeface r21 = dn.a.G(r20, r17, r18);
        Paint r22 = this.f3510c;
        r22.setTextSize(r16);
        r22.setTypeface(r21);
        float r23 = r22.measureText(r11);
    L14:
        JavaOnlyMap r24 = new JavaOnlyMap();
        r24.put("width", Float.valueOf(r23));
        r10.invoke(new Object[]{0, r24});
        return;
    L11:
        r20 = 400;
        goto L12
    L7:
        r16 = 20.0f;
        goto L8
    L13:
        r23 = 0.0f;
        goto L14
    }
}
