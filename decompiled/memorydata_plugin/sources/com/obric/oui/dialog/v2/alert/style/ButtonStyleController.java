package com.obric.oui.dialog.v2.alert.style;

import android.content.DialogInterface;
import android.view.View;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.oui.dialog.base.AbstractDialog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u0000 \u00162\u00020\u0001:\u0003\u0015\u0016\u0017B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0004H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H&J(\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J(\u0010\u0011\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J0\u0010\u0012\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0014H&¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/style/ButtonStyleController;", "Lcom/obric/oui/dialog/v2/alert/style/StyleController;", "()V", "getNegativeButton", "Landroid/view/View;", "getNeutralButton", "getPositiveButton", "setCustomNegativeButton", "", "view", "setNegativeButton", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "listener", "Landroid/content/DialogInterface$OnClickListener;", "textColorType", "Lcom/obric/oui/dialog/v2/alert/style/ButtonStyleController$TextColorType;", "setNeutralButton", "setPositiveButton", "positiveButtonWarning", "", "ButtonStyle", "Companion", "TextColorType", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ButtonStyleController implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13822a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/style/ButtonStyleController$TextColorType;", "", "(Ljava/lang/String;I)V", "TextReverse", "TextReverse2", "Negative", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Deprecated(message = "待废弃")
    public static final enum TextColorType extends Enum<TextColorType> {
        private static final /* synthetic */ TextColorType[] $VALUES = null;
        public static final TextColorType Negative = null;
        public static final TextColorType TextReverse = null;
        public static final TextColorType TextReverse2 = null;

        private static final /* synthetic */ TextColorType[] $values() {
            return new TextColorType[]{TextReverse, TextReverse2, Negative};
        }

        static {
            TextReverse = new TextColorType("TextReverse", 0);
            TextReverse2 = new TextColorType("TextReverse2", 1);
            Negative = new TextColorType("Negative", 2);
            $VALUES = $values();
        }

        private TextColorType(String r1, int r2) {
            super(r1, r2);
        }

        public static TextColorType valueOf(String r2) {
            return (TextColorType) ZeusTransformUtils.preCheckCast(Enum.valueOf(TextColorType.class, r2), TextColorType.class, "com.obric.memorydata.plugin");
        }

        public static TextColorType[] values() {
            return (TextColorType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TextColorType[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/style/ButtonStyleController$Companion;", "", "()V", "HORIZONTAL", "", "PRIMARY", "VERTICAL", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f13822a = new a(null);
    }

    public ButtonStyleController() {
    }

    public abstract View a();

    public abstract void a(View r1);

    @Override // com.obric.oui.dialog.v2.alert.style.g
    public void a(AbstractDialog r3) {
        g.a.a((g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin"), r3);
    }

    @Override // com.obric.oui.dialog.v2.alert.style.g
    public void a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        g.a.a((g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin"), r4);
    }

    public abstract void a(CharSequence r1, DialogInterface.OnClickListener r2, TextColorType r3);

    public abstract void a(CharSequence r1, DialogInterface.OnClickListener r2, TextColorType r3, boolean r4);

    public abstract View b();

    public abstract void b(CharSequence r1, DialogInterface.OnClickListener r2, TextColorType r3);

    public abstract View c();
}
