package com.obric.oui.infopanel.content;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ai.event.MessageIndication;
import com.lynx.tasm.utils.a;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import vn.h;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/oui/infopanel/content/OInfoPanelContentEntranceView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", MessageIndication.CONTENT_TYPE_TEXT, "", "setEntranceText", "(Ljava/lang/CharSequence;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OInfoPanelContentEntranceView extends ConstraintLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f13522i = 0;
    public final TextView g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ViewGroup f13523h;

    @JvmOverloads
    public OInfoPanelContentEntranceView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new h(this, 1));
    }

    public final void setEntranceText(CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
        this.g.setText(r5);
    }

    @JvmOverloads
    public OInfoPanelContentEntranceView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        View.inflate(r5, R$layout.o_info_panel_content_entrance_view, this);
        ViewGroup.MarginLayoutParams r11 = new ViewGroup.MarginLayoutParams(-1, -2);
        r11.setMargins(0, a.B(8, this), 0, a.B(12, this));
        setLayoutParams(r11);
        this.g = (TextView) findViewById(R$id.tv_title);
        ImageView r12 = (ImageView) findViewById(R$id.iv_arrow);
        this.f13523h = (ViewGroup) findViewById(R$id.entrance_container);
    }
}
