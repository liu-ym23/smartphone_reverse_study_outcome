package ddb;

import android.view.View;
import com.ss.android.lark.export.api.UrlPreviewApi;
import com.ss.android.lark.export.empty.EmptyProperty;
import com.ss.android.lark.export.engine.smartcard.SmartCardEngineProperty;
import com.ss.android.lark.export.entity.CardComponent;
import com.ss.android.lark.export.entity.Type;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.flexlayout.FlexLayoutProperty;
import com.ss.android.lark.tangram.base.props.Props;
import com.ss.android.lark.tangram.base.style.TCStyle;
import com.ss.android.lark.url.card.c;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.ttvideoengine.utils.ScreenUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import q6c.e;
import vcb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final d a;

    /* JADX INFO: renamed from: ddb.a$a, reason: collision with other inner class name */
    public static final class C0211a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Type.values().length];
            r0[Type.EMPTY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Type.FLEX_LAYOUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Type.ENGINE_VIEW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public a(d r2) {
        Intrinsics.checkNotNullParameter(r2, "dependency");
        this.a = r2;
    }

    public final q6c.b b(String r14, Map r15) {
        if (r14 == null) goto L36;
        if (r15 == null) goto L40;
        CardComponent r16 = (CardComponent) r15.get(r14);
        if (r16 != null) goto L9;
        return null;
    L9:
        BaseProperty r17 = r16.getProperty();
        TCStyle r1 = r16.getStyle();
        int r18 = b.a[r16.getType().ordinal()];
        if (r18 == 1) goto L35;
        if (r18 == 2) goto L30;
        if (r18 == 3) goto L17;
        return null;
    L17:
        if ((r17 instanceof SmartCardEngineProperty) == false) goto L19;
        SmartCardEngineProperty r19 = (SmartCardEngineProperty) r17;
    L20:
        com.ss.android.lark.export.a<? extends e<? extends Props, ? extends View, ? extends r6c.a>> r110 = ((UrlPreviewApi) ApiUtils.getApi(UrlPreviewApi.class)).getCardEngineComponentFactory(r19.getEngineType());
        if (r110 == null) goto L23;
        r110.a();
    L23:
        if (r110 == null) goto L25;
        c r111 = r110.b(r19, r1, this.a);
    L27:
        if ((r111 instanceof q6c.b) == true) goto L38;
        return null;
    L38:
        return r111;
    L25:
        r111 = null;
        goto L27
    L19:
        r19 = new SmartCardEngineProperty(null, null, 3, null);
        goto L20
    L30:
        if ((r17 instanceof FlexLayoutProperty) == false) goto L32;
        FlexLayoutProperty r112 = (FlexLayoutProperty) r17;
    L39:
        return new adb.a(r112, r1, this.a);
    L32:
        r112 = new FlexLayoutProperty(null, null, 0.0f, 0.0f, null, null, null, false, ScreenUtils.MAX_SYSTEM_BRIGHTNESS, null);
        goto L39
    L35:
        return new wcb.a(new EmptyProperty(), r1, this.a);
    L40:
        return null;
    L36:
        return null;
    }

    public final void a(q6c.b r6, String r7, Map r8) {
        if (r7 == null) goto L23;
        if (r8 == null) goto L29;
        CardComponent r9 = (CardComponent) r8.get(r7);
        if (r9 != null) goto L8;
        return;
    L8:
        Iterator<T> r10 = r9.getChildIds().iterator();
    L10:
        if (r10.hasNext() == false) goto L30;
        String r0 = (String) r10.next();
        q6c.b r1 = b(r0, r8);
        if (r1 == null) goto L10;
        if ((r6 instanceof e) == false) goto L17;
        ArrayList r2 = new ArrayList();
        r2.add(r1);
        e r3 = (e) r6;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r2, "components");
        ((q6c.b) r3).d = r2;
    L22:
        a(r1, r0, r8);
        goto L10
    L17:
        if ((r6 instanceof q6c.d) == false) goto L22;
        q6c.d r4 = (q6c.d) r6;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r1, "component");
        if (((q6c.b) r4).d != null) goto L21;
        ((q6c.b) r4).d = new ArrayList();
    L21:
        ArrayList r5 = ((q6c.b) r4).d;
        Intrinsics.checkNotNull(r5);
        r5.add(r1);
        goto L22
    L30:
        return;
    L29:
        return;
    }
}
