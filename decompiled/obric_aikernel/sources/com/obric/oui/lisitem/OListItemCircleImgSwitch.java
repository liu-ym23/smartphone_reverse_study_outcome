package com.obric.oui.lisitem;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import com.obric.oui.oswitch.OSwitch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/lisitem/OListItemCircleImgSwitch;", "Lcom/obric/oui/lisitem/OListItemCircleImg;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "listener", "", "setOnCheckedChangeListener", "", "checked", "setChecked", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class OListItemCircleImgSwitch extends OListItemCircleImg {
    private final OSwitch F;
    private CompoundButton.OnCheckedChangeListener G;

    static final class a implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OListItemCircleImgSwitch f6884a;

        a(OListItemCircleImgSwitch r10) {
            this.f6884a = r10;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r10, boolean r11) {
            CompoundButton.OnCheckedChangeListener r12 = OListItemCircleImgSwitch.j(this.f6884a);
            if (r12 == null) goto L6;
            r12.onCheckedChanged(r10, r11);
            return;
        }
    }

    public OListItemCircleImgSwitch(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        OSwitch r12 = new OSwitch(r10, null, 0, 6, null);
        r12.setClickable(true);
        r12.setOnCheckedChangeListener(new a(this));
        Unit r13 = Unit.INSTANCE;
        this.F = r12;
        setTrailingView(r12);
    }

    public static final /* synthetic */ CompoundButton.OnCheckedChangeListener j(OListItemCircleImgSwitch r10) {
        return r10.G;
    }

    public final void setChecked(boolean r10) {
        this.F.setChecked(r10);
    }

    public final void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener r10) {
        this.G = r10;
    }
}
