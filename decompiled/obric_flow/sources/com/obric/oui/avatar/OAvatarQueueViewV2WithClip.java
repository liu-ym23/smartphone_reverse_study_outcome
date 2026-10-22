package com.obric.oui.avatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/avatar/OAvatarQueueViewV2WithClip;", "Landroid/view/View;", "", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OAvatarQueueViewV2WithClip extends View {
    @JvmOverloads
    public OAvatarQueueViewV2WithClip(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "ctx");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        super.onDraw(r5);
    }

    @JvmOverloads
    public OAvatarQueueViewV2WithClip(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "ctx");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OAvatarQueueViewV2WithClip(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OAvatarQueueViewV2WithClip(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "ctx");
        super(r5, r10, r11);
        new Paint().setAntiAlias(true);
        new ArrayList();
    }
}
