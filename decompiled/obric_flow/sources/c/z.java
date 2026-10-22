package c;

import android.content.DialogInterface;
import cn.nubia.neopush.commons.Constant;
import com.google.gson.JsonObject;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.zte.miboard.cards.express.login.LoginNumberActivity;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class z implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c0 f1093b;

    public z(c0 r5, int r10) {
        this.f1093b = r5;
        this.f1092a = r10;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r5, int r10) {
        c0 r11 = this.f1093b;
        List r12 = r11.f1031c;
        int r13 = this.f1092a;
        String r14 = (String) r12.get(r13);
        a0 r15 = new a0(r11, r14, r13);
        LoginNumberActivity r16 = r11.f1030b;
        l r17 = m.a(r16);
        JsonObject r18 = new JsonObject();
        m.c(r16, r18);
        r18.addProperty("phone", r14);
        r18.addProperty("version", 1);
        r18.addProperty(Constant.IMEI, k0.a(r16));
        r18.addProperty("androidId", k0.a(r16));
        r18.addProperty("action", 2);
        r18.addProperty("newSF", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        j0.b(r17.i(r18), r15);
    }
}
