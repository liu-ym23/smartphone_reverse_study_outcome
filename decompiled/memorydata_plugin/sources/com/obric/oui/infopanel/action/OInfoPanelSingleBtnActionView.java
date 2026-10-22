package com.obric.oui.infopanel.action;

import android.view.View;
import android.widget.LinearLayout;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.oui.button.OButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0015B#\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/infopanel/action/OInfoPanelSingleBtnActionView;", "Landroid/widget/LinearLayout;", "Lcom/obric/oui/infopanel/action/IOInfoPanelActionView;", "context", "Landroid/content/Context;", "style", "Lcom/obric/oui/infopanel/action/OInfoPanelSingleBtnActionView$Style;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Lcom/obric/oui/infopanel/action/OInfoPanelSingleBtnActionView$Style;Landroid/util/AttributeSet;)V", "showingBtn", "Lcom/obric/oui/button/OButton;", "getView", "Landroid/view/View;", "setBtnOnClickListener", "", "listener", "Landroid/view/View$OnClickListener;", "setBtnText", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "Style", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OInfoPanelSingleBtnActionView extends LinearLayout implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OButton f13962a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/infopanel/action/OInfoPanelSingleBtnActionView$Style;", "", "(Ljava/lang/String;I)V", "PRIMARY", "SECONDARY", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Style extends Enum<Style> {
        private static final /* synthetic */ Style[] $VALUES = null;
        public static final Style PRIMARY = null;
        public static final Style SECONDARY = null;

        private static final /* synthetic */ Style[] $values() {
            return new Style[]{PRIMARY, SECONDARY};
        }

        static {
            PRIMARY = new Style("PRIMARY", 0);
            SECONDARY = new Style("SECONDARY", 1);
            $VALUES = $values();
        }

        private Style(String r1, int r2) {
            super(r1, r2);
        }

        public static Style valueOf(String r2) {
            return (Style) ZeusTransformUtils.preCheckCast(Enum.valueOf(Style.class, r2), Style.class, "com.obric.memorydata.plugin");
        }

        public static Style[] values() {
            return (Style[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Style[].class, "com.obric.memorydata.plugin");
        }
    }

    @Override // com.obric.oui.infopanel.action.a
    public View getView() {
        return (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
    }

    public final void setBtnOnClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.f13962a.setOnClickListener(r4);
    }

    public final void setBtnText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        this.f13962a.setText(r4);
    }
}
