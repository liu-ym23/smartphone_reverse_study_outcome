package com.obric.contactsdk;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.obric.memorydata.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fJ\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/contactsdk/CallFeatureObserver;", "Landroid/database/ContentObserver;", "handler", "Landroid/os/Handler;", "mContext", "Landroid/content/Context;", "(Landroid/os/Handler;Landroid/content/Context;)V", "delayMillis", "", "getHandler", "()Landroid/os/Handler;", "getMContext", "()Landroid/content/Context;", "pendingCallSummaryFlag", "", "", "updateCallSummaryDataRunnable", "Ljava/lang/Runnable;", "convertCallFlagToList", "", "ids", "onChange", "", "selfChange", "", "uri", "Landroid/net/Uri;", "Companion", "contactsdk_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class a extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0385a f7848a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f7849b;
    private final Context c;
    private final Set<String> d;
    private final long e;
    private final Runnable f;

    /* JADX INFO: renamed from: com.obric.contactsdk.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/contactsdk/CallFeatureObserver$Companion;", "", "()V", "TAG", "", "contactsdk_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class C0385a {
        private C0385a() {
        }

        public /* synthetic */ C0385a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f7848a = new C0385a(null);
    }

    public a(Handler r3, Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "handler");
        Intrinsics.checkNotNullParameter(r5, "mContext");
        super(r3);
        this.f7849b = r3;
        this.c = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.d = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        this.e = 1000;
        this.f = new $$Lambda$a$bWeZSFmpG7OadLAYGJ4iy7snyOM(this);
    }

    private static final void a(a r6) {
        Intrinsics.checkNotNullParameter(r6, "this$0");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6.d, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L17;
        List<String> r0 = com.obric.contactsdk.loader.d.a(r6.c, CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r6.d, Iterable.class, "com.obric.memorydata.plugin")));
        com.obric.a.a.f.f5867a.a("CallFeatureObserver", "updateCallSummaryDataRunnable: " + r0);
        r6.d.clear();
        ContentResolver r1 = r6.c.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r1, "getContentResolver(...)");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        Long r5 = StringsKt.toLongOrNull((String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin"));
        if (r5 == null) goto L6;
        r3.add(r5);
        goto L6
    L10:
        com.obric.a.a.b.f5863a.a(com.obric.contactsdk.loader.d.a(com.obric.contactsdk.loader.d.a(r1, (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), r6.c)));
        return;
    }

    public static /* synthetic */ void lambda$bWeZSFmpG7OadLAYGJ4iy7snyOM(a r0) {
        a(r0);
    }

    public final List<String> a(String r9) {
        List<String> r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L20;
        return r8;
    L20:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{","}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L17
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L17
        Iterator r11 = r10.iterator();     // Catch: Exception -> L17
    L13:
        if (r11.hasNext() == false) goto L15;
        r2.add(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString());     // Catch: Exception -> L17
        goto L13
    L15:
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
    L17:
        e = move-exception;
        System.out.println("Error converting call flags to list: " + e.getMessage());
        return r8;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r6, Uri r7) {
        super.onChange(r6, r7);
        String r8 = null;
        if (r7 == null) goto L5;
        String r0 = r7.getQueryParameter("callFlag");
    L6:
        if (r7 == null) goto L8;
        r8 = r7.getQueryParameter("action");
    L8:
        com.obric.a.a.f r9 = com.obric.a.a.f.f5867a;
        StringBuilder r2 = new StringBuilder().append("onChange: action [").append(r8).append("], callFlags [");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L11;
    L14:
        boolean r4 = true;
    L15:
        r9.a("CallFeatureObserver", r2.append(r4).append(']').toString());
        if (r8 == null) goto L41;
        if (r0 == null) goto L44;
        List<String> r10 = a(r0);
        int r1 = r8.hashCode();
        if (r1 == (-1335458389)) goto L32;
        if (r1 == (-1183792455)) goto L29;
        if (r1 == (-838846263)) goto L26;
        return;
    L26:
        if (r8.equals(BuildConfig.CHANNEL) == false) goto L48;
    L33:
        Set<String> r11 = this.d;
        monitor-enter(r11);
        this.d.addAll((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L38
        monitor-exit(r11);
        this.f7849b.removeCallbacks(this.f);
        this.f7849b.postDelayed(this.f, this.e);
        return;
    L38:
        th = move-exception;
        throw th;
    L48:
        return;
    L29:
        if (r8.equals("insert") == true) goto L33;
        return;
    L32:
        if (r8.equals("delete") == true) goto L33;
        return;
    L44:
        return;
    L41:
        return;
    L11:
        if (r3.length() == 0) goto L14;
        r4 = false;
        goto L15
    L5:
        r0 = null;
        goto L6
    }
}
