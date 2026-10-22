package com.bytedance.android.live.lynx.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Region;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\n\u000bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/lynx/ui/MultiLinkCustomClipImage;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Lcom/bytedance/android/live/core/widget/HSImageView;", "", "src", "", "setSrc", "Lf6a/a;", "slots", "setSlots", "a", "b", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiLinkCustomClipImage extends LynxUI<HSImageView> {

    public static final class a {
    }

    public static final class b extends HSImageView {
        public Path a;

        public b(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void draw(Canvas r3) {
            Intrinsics.checkNotNullParameter(r3, "canvas");
            Path r0 = this.a;
            if (r0 == null) goto L5;
            Intrinsics.checkNotNull(r0);
            r3.clipPath(r0, Region.Op.DIFFERENCE);
        L5:
            super/*android.widget.ImageView*/.draw(r3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void setClipPath(Path r1) {
            this.a = r1;
            invalidate();
        }
    }

    static {
    }

    public final void onDetach() {
        super.onDetach();
        b r0 = (b) getView();
        if (r0 == null) goto L6;
        r0.a = null;
        return;
    }

    public MultiLinkCustomClipImage(LynxContext r1) {
        super(r1);
    }

    public final View createView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new b(r2);
    }

    @LynxProp(name = "slots")
    public final void setSlots(f6a.a r10) {
        Intrinsics.checkNotNullParameter(r10, "slots");
        Objects.toString(r10.asArray());
        ReadableArray r11 = r10.asArray();     // Catch: Exception -> L20
        if (r11 != null) goto L6;
    L18:
        com.lynx.tasm.event.a r12 = new com.lynx.tasm.event.a(getSign(), "loadImage");     // Catch: Exception -> L20
        getLynxContext().getEventEmitter().sendCustomEvent(r12);     // Catch: Exception -> L20
        return;
    L6:
        if (getView() == null) goto L18;
        Path r0 = new Path();     // Catch: Exception -> L20
        int r7 = r11.size();     // Catch: Exception -> L20
        int r8 = 0;
    L8:
        if (r8 >= r7) goto L13;
        ReadableMap r1 = r11.getMap(r8);     // Catch: Exception -> L20
        if (r1 == null) goto L12;
        float r2 = s1.e((float) r1.getDouble("x"));     // Catch: Exception -> L20
        float r3 = s1.e((float) r1.getDouble("y"));     // Catch: Exception -> L20
        float r4 = s1.e((float) r1.getDouble("w"));     // Catch: Exception -> L20
        r0.addRect(r2, r3, r4 + r2, r3 + s1.e((float) r1.getDouble("h")), Path.Direction.CW);     // Catch: Exception -> L20
    L12:
        r8 = r8 + 1;     // Catch: Exception -> L20
        goto L8
    L13:
        HSImageView r13 = getView();     // Catch: Exception -> L20
        if (r13 == null) goto L17;
        ((b) r13).setClipPath(r0);     // Catch: Exception -> L20
        goto L18
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.lynx.ui.MultiLinkCustomClipImage.CustomClipImageView");     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.getMessage();
    }

    @LynxProp(name = "src")
    public final void setSrc(String r3) {
        Intrinsics.checkNotNullParameter(r3, "src");
        if (TextUtils.isEmpty(r3) == false) goto L7;
        HSImageView r0 = getView();
        if (r0 == null) goto L10;
        r0.setVisibility(8);
    L10:
        HSImageView r1 = getView();
        if (r1 == null) goto L14;
        r1.setImageURI(r3);
        return;
    L14:
        return;
    L7:
        HSImageView r2 = getView();
        if (r2 == null) goto L10;
        r2.setVisibility(0);
        goto L10
    }
}
