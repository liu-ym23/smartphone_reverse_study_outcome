package ofa;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.common.apphost.AppHost;
import com.larus.utils.e1;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c {
    public ItemTextArrow a;
    public ItemTextArrow b;
    public ItemTextArrow c;
    public ItemTextArrow d;
    public Function5<? super View, ? super String, ? super String, ? super String, ? super String, Unit> e;
    public Lifecycle f;
    public a g;

    public c() {
    }

    public final void b() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        a r1 = this.g;
        if (r1 == null) goto L7;
        Lifecycle r2 = this.f;
        if (r2 == null) goto L7;
        r2.removeObserver(r1);
    L7:
        this.g = null;
        this.f = null;
    }

    public final void a(ItemTextArrow r9, final String r10) {
        if (r9 != null) goto L4;
        return;
    L4:
        e1.x(r9);
        TextView r0 = r9.getTextView();
        Integer r2 = null;
        switch(r10.hashCode()) {
            case -178324674: goto L20;
            case -172298781: goto L16;
            case 114009: goto L12;
            case 951526432: goto L8;
            default: goto L23;
        };
    L23:
        String r1 = null;
    L24:
        r0.setText(r1);
        switch(r10.hashCode()) {
            case -178324674: goto L40;
            case -172298781: goto L36;
            case 114009: goto L32;
            case 951526432: goto L28;
            default: goto L43;
        };
    L43:
        String r3 = null;
    L44:
        if (r3 != null) goto L46;
        r3 = "";
    L46:
        r9.Z5(r3, null);
        switch(r10.hashCode()) {
            case -178324674: goto L62;
            case -172298781: goto L58;
            case 114009: goto L54;
            case 951526432: goto L50;
            default: goto L65;
        };
    L65:
        if (r2 == null) goto L67;
        int r4 = r2.intValue();
    L68:
        r9.setImageSrc(r4);
        e1.d(r9, new b(this, r10));
        return;
    L67:
        r4 = 0;
        goto L68
    L50:
        if (r10.equals("contact") == false) goto L65;
        r2 = 2131244485;
        goto L65
    L54:
        if (r10.equals("sms") == false) goto L65;
        r2 = 2131244509;
        goto L65
    L58:
        if (r10.equals("call_log") == false) goto L65;
        r2 = 2131244441;
        goto L65
    L62:
        if (r10.equals("calendar") == false) goto L65;
        r2 = 2131244440;
        goto L65
    L28:
        if (r10.equals("contact") == false) goto L70;
        r3 = AppHost.a.getApplication().getString(2131912334);
        goto L44
    L70:
        r3 = null;
        goto L44
    L32:
        if (r10.equals("sms") == false) goto L71;
        r3 = AppHost.a.getApplication().getString(2131912335);
        goto L44
    L71:
        r3 = null;
        goto L44
    L36:
        if (r10.equals("call_log") == false) goto L72;
        r3 = AppHost.a.getApplication().getString(2131912333);
        goto L44
    L72:
        r3 = null;
        goto L44
    L40:
        if (r10.equals("calendar") == false) goto L73;
        r3 = AppHost.a.getApplication().getString(2131912332);
        goto L44
    L73:
        r3 = null;
        goto L44
    L8:
        if (r10.equals("contact") == false) goto L74;
        r1 = AppHost.a.getApplication().getString(2131912617);
        goto L24
    L74:
        r1 = null;
        goto L24
    L12:
        if (r10.equals("sms") == false) goto L75;
        r1 = AppHost.a.getApplication().getString(2131912618);
        goto L24
    L75:
        r1 = null;
        goto L24
    L16:
        if (r10.equals("call_log") == false) goto L76;
        r1 = AppHost.a.getApplication().getString(2131912616);
        goto L24
    L76:
        r1 = null;
        goto L24
    L20:
        if (r10.equals("calendar") == false) goto L77;
        r1 = AppHost.a.getApplication().getString(2131912615);
        goto L24
    L77:
        r1 = null;
        goto L24
    }
}
