package com.obric.memorydata.markdown.custom;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.database.entity.fx;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.az;
import com.obric.memorydata.utils.ba;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\nJ \u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\nJ\u0016\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\nJ\u0016\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\nJ\"\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\f\u001a\u00020\nH\u0002J0\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\t2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0016\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\n¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/markdown/custom/PhoneActions;", "", "<init>", "()V", "showPicker", "", "context", "Landroid/content/Context;", "phones", "", "", "dial", "number", "sendSms", "body", "addContact", "copyNumber", "jumpToContact", "contact", "Lcom/obric/memorydata/database/entity/RawContactEntity;", "viewContactFromDb", "contacts", "parentDialog", "Lcom/obric/memorydata/markdown/custom/OMenuDialog;", "showMenu", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f9994a = null;

    static {
        f9994a = new j();
    }

    private j() {
    }

    private final void a(Context r6, fx r7, String r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
    L24:
        Intent r1 = new Intent("android.intent.action.MAIN");     // Catch: Throwable -> L21
        r1.addCategory("android.intent.category.APP_CONTACTS");     // Catch: Throwable -> L21
        if (a.a(r9, r1) == true) goto L15;
        return;
    L15:
        if (r7 == null) goto L18;
        String r10 = r7.a();     // Catch: Throwable -> L21
        if (r10 == null) goto L18;
    L19:
        String r11 = r9.getString(ZeusTransformUtils.mapRes(R.string.markdown_action_search_contact_hint, TypedValues.Custom.S_STRING, "markdown_action_search_contact_hint"), new Object[]{r10});     // Catch: Throwable -> L21
        Intrinsics.checkNotNullExpressionValue(r11, "getString(...)");     // Catch: Throwable -> L21
        ba.a(r9, r11, 80);     // Catch: Throwable -> L21
        return;
    L18:
        r10 = r8;
    L21:
        a(r9, r8);
        return;
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7.getEntityId(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L24;
        if (a.a(r9, new Intent("android.intent.action.VIEW", Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, r7.getEntityId()))) == false) goto L24;
        return;
    L7:
        r2 = false;
        goto L8
    }

    private static final void a(Context r1, fx r2, String r3, h r4, View r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        f9994a.a(r6, r2, r3);
        r4.b();
    }

    private static final void a(Context r1, String r2, View r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        f9994a.a(r4, r2);
    }

    private final void a(Context r6, List<fx> r7, final String r8, h r9) {
        final Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L6;
        r9.b();
    L6:
        if (r11.size() <= 1) goto L17;
        final h r5 = new h(r10);
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r12.iterator();
    L9:
        if (r13.hasNext() == false) goto L11;
        r0.add(((fx) ZeusTransformUtils.preCheckCast(r13.next(), fx.class, "com.obric.memorydata.plugin")).a());
        goto L9
    L11:
        List<String> r14 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r15.iterator();
    L13:
        if (r16.hasNext() == false) goto L15;
        final fx r2 = (fx) ZeusTransformUtils.preCheckCast(r16.next(), fx.class, "com.obric.memorydata.plugin");
        r1.add(new $$Lambda$j$SZoN5U9CCgtXenzJdeQeelYAM(r10, r2, r8, r5));
        goto L13
    L15:
        List<? extends View.OnClickListener> r17 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        r5.a(r8);
        r5.a(r14, r17);
        r5.a();
        return;
    L17:
        if (r11.size() != 1) goto L19;
        fx r18 = (fx) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r11), fx.class, "com.obric.memorydata.plugin");
    L20:
        a(r10, r18, r8);
        return;
    L19:
        r18 = null;
        goto L20
    }

    public static final /* synthetic */ void a(j r2, Context r3, List r4, String r5, h r6) {
        r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), r5, r6);
    }

    public static /* synthetic */ void lambda$Ik6qemmIcWHo0_z2q6AquBNaWfc(Context r0, String r1, View r2) {
        a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$SZoN5U9CCgtXenzJ-deQeel-YAM, reason: not valid java name */
    public static /* synthetic */ void m681lambda$SZoN5U9CCgtXenzJdeQeelYAM(Context r0, fx r1, String r2, h r3, View r4) {
        a(r0, r1, r2, r3, r4);
    }

    public final void a(Context r3, String r4) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "number");
        a.a(r2, new Intent("android.intent.action.DIAL", Uri.parse("tel:" + r4)));
    }

    public final void a(Context r2, String r3, String r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r3, "number");
        Intent r5 = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + r3));
        if (r4 == null) goto L5;
        r5.putExtra("sms_body", r4);
    L5:
        a.a(r1, r5);
    }

    public final void a(Context r5, List<String> r6) {
        final Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r7, "phones");
        List<String> r8 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin"));
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        final String r2 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");
        r1.add(new $$Lambda$j$Ik6qemmIcWHo0_z2q6AquBNaWfc(r4, r2));
        goto L4
    L6:
        List<? extends View.OnClickListener> r11 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        h r0 = new h(r4);
        String r12 = r4.getString(ZeusTransformUtils.mapRes(R.string.markdown_action_call_phone, TypedValues.Custom.S_STRING, "markdown_action_call_phone"));
        Intrinsics.checkNotNullExpressionValue(r12, "getString(...)");
        r0.a(r12);
        r0.a(r8, r11);
        r0.a();
    }

    public final void b(Context r3, String r4) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "number");
        Intent r5 = new Intent("android.intent.action.INSERT");
        r5.setType("vnd.android.cursor.dir/raw_contact");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        r5.putExtra(MemoryKeyInfoEntity.KEY_PHONE, r4);
    L8:
        a.a(r2, r5);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void c(Context r2, String r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r3, "number");
        a.a(r1, MemoryKeyInfoEntity.KEY_PHONE, r3);
    }

    public final void d(Context r8, String r9) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r9, "number");
        String r10 = az.c(r9);
        kotlinx.coroutines.i.a(a.a(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new PhoneActions$showMenu$1(r10, r7, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }
}
