package com.ss.android.lark.flow.common.utils;

import android.content.Context;
import androidx.core.graphics.ColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.flow.common.component.tag.FlowTagView;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowTagBuilder {
    public final Context a;
    public final ahb.a b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public final Lazy k;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FlowTagType.values().length];
            r0[FlowTagType.PUBLIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[FlowTagType.DEPARTMENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[FlowTagType.RESIGNED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[FlowTagType.FROZEN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[FlowTagType.BLOCK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[FlowTagType.ON_LEAVE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[FlowTagType.EXTERNAL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[FlowTagType.AGENT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    static {
    }

    public final FlowTagView b() {
        Log.i("FlowTagBuilder", "isPublic = " + this.c + ", isDepartment = " + this.d + ", isResigned = " + this.e + ", isFrozen = " + this.f + ", isBlock = " + this.g + ", isOnLeave = " + this.h + ", isExternal = " + this.i);
        boolean r0 = ((com.ss.android.lark.passport.dpop.b) this.k.getValue()).isDoubaoBUser();
        StringBuilder r2 = new StringBuilder("isDoubaoBuser = ");
        r2.append(r0);
        Log.i("FlowTagBuilder", r2.toString());
        ArrayList r3 = new ArrayList();
        a(r3, FlowTagType.RESIGNED, this.e);
        a(r3, FlowTagType.FROZEN, this.f);
        a(r3, FlowTagType.ON_LEAVE, this.h);
        a(r3, FlowTagType.EXTERNAL, this.i);
        a(r3, FlowTagType.PUBLIC, this.c);
        a(r3, FlowTagType.DEPARTMENT, this.d);
        a(r3, FlowTagType.BLOCK, this.g);
        a(r3, FlowTagType.AGENT, this.j);
        Intrinsics.checkNotNullParameter(r3, "candidates");
        com.ss.android.lark.flow.common.utils.a r4 = (com.ss.android.lark.flow.common.utils.a) CollectionsKt.firstOrNull(CollectionsKt.sortedWith(r3, new c(new com.ss.android.lark.flow.common.utils.b())));
        if (r4 != null) goto L6;
        return null;
    L6:
        Log.i("FlowTagBuilder", "build tag type = " + r4.getType());
        switch(b.a[r4.getType().ordinal()]) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            default: goto L9;
        };
    L10:
        Context r1 = this.a;
        return c(r1, UIUtils.getString(r1, 2131890271), UIUtils.getColor(this.a, 2131102049), UIUtils.getColor(this.a, 2131102057));
    L11:
        Context r5 = this.a;
        return c(r5, UIUtils.getString(r5, 2131890008), UIUtils.getColor(this.a, 2131102049), UIUtils.getColor(this.a, 2131102057));
    L12:
        Context r6 = this.a;
        return c(r6, UIUtils.getString(r6, 2131890018), UIUtils.getColor(this.a, 2131102039), ColorUtils.setAlphaComponent(UIUtils.getColor(this.a, 2131102039), 51));
    L13:
        Context r7 = this.a;
        return c(r7, UIUtils.getString(r7, 2131890690), UIUtils.getColor(this.a, 2131102036), ColorUtils.setAlphaComponent(UIUtils.getColor(this.a, 2131102036), 51));
    L14:
        Context r8 = this.a;
        return c(r8, UIUtils.getString(r8, 2131890021), UIUtils.getColor(this.a, 2131102036), ColorUtils.setAlphaComponent(UIUtils.getColor(this.a, 2131102036), 51));
    L19:
        Context r9 = this.a;
        return c(r9, UIUtils.getString(r9, 2131890006), UIUtils.getColor(this.a, 2131102049), UIUtils.getColor(this.a, 2131102057));
    L20:
        Context r10 = this.a;
        return c(r10, UIUtils.getString(r10, 2131890020), UIUtils.getColor(this.a, 2131102049), UIUtils.getColor(this.a, 2131102057));
    L9:
        throw new NoWhenBranchMatchedException();
    L16:
        if (r0 != true) goto L18;
        Context r11 = this.a;
        return c(r11, UIUtils.getString(r11, 2131889998), UIUtils.getColor(this.a, 2131102042), UIUtils.getColor(this.a, 2131102045));
    L18:
        Context r12 = this.a;
        return c(r12, UIUtils.getString(r12, 2131890005), UIUtils.getColor(this.a, 2131102042), UIUtils.getColor(this.a, 2131102045));
    }

    public final Context getContext() {
        return this.a;
    }

    public FlowTagBuilder(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this.a = r8;
        this.b = new ahb.a(0.0f, 0.0f, 0.0f, 0.0f, 63);
        this.k = LazyKt.lazy(FlowTagBuilder$tokenService$2.INSTANCE);
    }

    public static void a(List r1, FlowTagType r2, boolean r3) {
        if (r3 == false) goto L5;
        ArrayList r4 = (ArrayList) r1;
        r4.add(new com.ss.android.lark.flow.common.utils.a(r2, r4.size()));
        return;
    }

    public final FlowTagView c(Context r5, String r6, int r7, int r8) {
        FlowTagView r0 = new FlowTagView(r5, null, 6, 0);
        r0.setTagStyle(this.b);
        r0.setText(r6);
        r0.setTextColor(r7);
        r0.setTagBackgroundColor(r8);
        return r0;
    }
}
