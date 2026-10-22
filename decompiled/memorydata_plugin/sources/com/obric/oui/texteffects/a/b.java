package com.obric.oui.texteffects.a;

import android.graphics.Canvas;
import android.text.Layout;
import android.text.TextPaint;
import android.widget.TextView;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H&J\b\u0010&\u001a\u00020#H&J\u0018\u0010'\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010(\u001a\u00020)H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0012\u0010 \u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0005¨\u0006*"}, d2 = {"Lcom/obric/oui/texteffects/host/TextViewEffectHost;", "", "baseline", "", "getBaseline", "()I", "currentTextColor", "getCurrentTextColor", "density", "", "getDensity", "()F", "height", "getHeight", "layout", "Landroid/text/Layout;", "getLayout", "()Landroid/text/Layout;", "measuredWidth", "getMeasuredWidth", "paint", "Landroid/text/TextPaint;", "getPaint", "()Landroid/text/TextPaint;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "getText", "()Ljava/lang/CharSequence;", "view", "Landroid/widget/TextView;", "getView", "()Landroid/widget/TextView;", "width", "getWidth", "drawCompoundDrawables", "", "canvas", "Landroid/graphics/Canvas;", "invalidate", "setInternalText", "bufferType", "Landroid/widget/TextView$BufferType;", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface b {
    TextView a();

    void a(Canvas r1);

    void a(CharSequence r1, TextView.BufferType r2);

    CharSequence b();

    TextPaint c();

    Layout d();

    int e();

    int f();

    int g();

    int h();

    float i();
}
