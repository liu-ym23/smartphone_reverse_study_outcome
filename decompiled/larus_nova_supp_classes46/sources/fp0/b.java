package fp0;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.AppPrivilege;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final void a(TextView r13, HSImageView r14, View r15, View r16, View r17, View r18, Function2 r19, MiniAppEntranceCell r20, int r21) {
        String r5 = r20.title;
        if (r5 != null) goto L5;
    L12:
        r5 = "";
    L13:
        r13.setText(r5);
        GenericDraweeHierarchy r6 = r14.getHierarchy();
        r14.setActualImageResource(2131252376);
        r6.setPlaceholderImage(2131252376);
        r6.setFailureImage(2131252376);
        r14.setHierarchy(r6);
        ImageModel r7 = r20.icon;
        if (r7 == null) goto L19;
        List r8 = r7.getUrls();
        if (r8 == null) goto L19;
        String r9 = (String) CollectionsKt.firstOrNull(r8);
        if (r9 == null) goto L19;
    L21:
        if (r9.length() <= 0) goto L23;
        boolean r10 = true;
    L24:
        if (r10 == true) goto L27;
        r9 = null;
    L27:
        if (r9 == null) goto L30;
        r14.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(UriProtector.parse(r9)).build());
    L30:
        if (Intrinsics.areEqual(((JSONObject) r20.a.getValue()).optString("app_privilege", ""), AppPrivilege.BIND_SELF_MOUNT.getValue()) == false) goto L32;
        r17.setVisibility(0);
        r16.setVisibility(8);
        r15.setVisibility(8);
    L33:
        Object r0 = n80.a.a;
        new n80.b(r18).throttleFirst(500, TimeUnit.MILLISECONDS).subscribe(new a(r19, r20, r21));
        return;
    L32:
        r17.setVisibility(8);
        r16.setVisibility(8);
        r15.setVisibility(8);
        goto L33
    L23:
        r10 = false;
    L19:
        r9 = "";
        goto L21
    L5:
        if (r20.groupId == 2) goto L7;
    L9:
        if (r5 != null) goto L13;
    L7:
        if (r5.length() <= 4) goto L9;
        r5 = r5.substring(0, 4) + "...";
        goto L9
    }
}
