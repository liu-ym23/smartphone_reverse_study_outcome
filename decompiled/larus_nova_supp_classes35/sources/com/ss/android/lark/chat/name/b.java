package com.ss.android.lark.chat.name;

import android.content.Context;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.translate.dialog.MoreTranslateActionDialog;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import z5c.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements MoreTranslateActionDialog.c {
    public final /* synthetic */ com.ss.android.lark.chat.name.a a;
    public final /* synthetic */ Chat b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ String d;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MoreTranslateActionDialog.MoreActionType.values().length];
            r0[MoreTranslateActionDialog.MoreActionType.Translate.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[MoreTranslateActionDialog.MoreActionType.HideTranslate.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[MoreTranslateActionDialog.MoreActionType.SwitchLanguage.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[MoreTranslateActionDialog.MoreActionType.Feedback.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.chat.name.ChatNameRenderer$doHideTranslate$1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a(int r10, MoreTranslateActionDialog.MoreActionType r11, fcc.c<?> r12) {
        Intrinsics.checkNotNullParameter(r11, IPortraitService.TYPE);
        int r13 = a.a[r11.ordinal()];
        if (r13 != 1) goto L5;
        com.ss.android.lark.chat.name.a r14 = this.a;
        s5c.a r15 = r.Z2;
        Chat r16 = this.b;
        r14.getClass();
        com.ss.android.lark.chat.name.a.a(r15, r16, null);
        com.ss.android.lark.chat.name.a r17 = this.a;
        Context r18 = this.c;
        Chat r19 = this.b;
        String r0 = this.d;
        r17.a.h3(r19.getId(), r0, false, new ChatNameRenderer$doTranslate$1(r19, r18));
        return;
    L5:
        if (r13 != 2) goto L7;
        com.ss.android.lark.chat.name.a r110 = this.a;
        s5c.a r111 = r.Y2;
        Chat r112 = this.b;
        r110.getClass();
        com.ss.android.lark.chat.name.a.a(r111, r112, null);
        com.ss.android.lark.chat.name.a r113 = this.a;
        final Context r114 = this.c;
        Chat r115 = this.b;
        r113.a.y3(r115.getId(), new ChatNameRenderer$doHideTranslate$1(r114));
        return;
    L7:
        if (r13 != 3) goto L9;
        if (r12 == null) goto L24;
        r12.j();
        return;
    L24:
        return;
    L9:
        if (r13 != 4) goto L16;
        com.ss.android.lark.chat.name.a r116 = this.a;
        s5c.a r117 = r.b3;
        Chat r118 = this.b;
        r116.getClass();
        com.ss.android.lark.chat.name.a.a(r117, r118, null);
        com.ss.android.lark.chat.name.a r119 = this.a;
        Chat r120 = this.b;
        Context r2 = this.c;
        r119.getClass();
        w4b.c.b r1 = ChatCoreModule.a().getAiDependency();
        Map r121 = ChatParamUtils.b(r120, null, 6);
        LinkedHashMap r8 = new LinkedHashMap(MapsKt.mapCapacity(r121.size()));
        Iterator r122 = r121.entrySet().iterator();
    L12:
        if (r122.hasNext() == false) goto L14;
        Map.Entry r123 = (Map.Entry) r122.next();
        r8.put(r123.getKey(), r123.getValue().toString());
        goto L12
    L14:
        r1.a(r2, r120.getId(), r120.getName(), r120.getTranslatedName(), r120.getNameMajorLanguage(), r120.getNameTranslateLanguage(), r8);
        return;
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public b(com.ss.android.lark.chat.name.a r1, Chat r2, Context r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
