package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.a.a.b;
import com.obric.a.a.f;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.contactsdk.g;
import com.obric.contactsdk.loader.d;
import com.obric.contactsdk.loader.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 )2\u00020\u0001:\u0001)B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u001d2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00110\u001d2\u0006\u0010'\u001a\u00020(H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"LCallContentObserver;", "Landroid/database/ContentObserver;", "handler", "Landroid/os/Handler;", "mContext", "Landroid/content/Context;", "(Landroid/os/Handler;Landroid/content/Context;)V", "delayMillis", "", "getHandler", "()Landroid/os/Handler;", "getMContext", "()Landroid/content/Context;", "pendingContactUris", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Landroid/net/Uri;", "pendingDeleteCallLogIds", "", "kotlin.jvm.PlatformType", "pendingDeleteContactIds", "pendingDeleteContactUris", "pendingIndexCallLogIds", "pendingIndexContactIds", "pendingIndexContactUris", "updateDeleteRunnable", "Ljava/lang/Runnable;", "updateIndexRunnable", "updateUriRunnable", "convertIdsToList", "", "ids", "onChange", "", "selfChange", "", "uri", "queryEntities", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "entityIds", "entityType", "", "Companion", "contactsdk_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class a extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0000a f7a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f8b;
    private final Context c;
    private final CopyOnWriteArraySet<String> d;
    private final CopyOnWriteArraySet<String> e;
    private final CopyOnWriteArraySet<String> f;
    private final CopyOnWriteArraySet<String> g;
    private final CopyOnWriteArraySet<Uri> h;
    private final CopyOnWriteArraySet<Uri> i;
    private final CopyOnWriteArraySet<Uri> j;
    private final long k;
    private final Runnable l;
    private final Runnable m;
    private final Runnable n;

    /* JADX INFO: renamed from: a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"LCallContentObserver$Companion;", "", "()V", "TAG", "", "contactsdk_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class C0000a {
        private C0000a() {
        }

        public /* synthetic */ C0000a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f7a = new C0000a(null);
    }

    public a(Handler r3, Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "handler");
        Intrinsics.checkNotNullParameter(r5, "mContext");
        super(r3);
        this.f8b = r3;
        this.c = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.d = new CopyOnWriteArraySet((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.emptyList(), Collection.class, "com.obric.memorydata.plugin"));
        this.e = new CopyOnWriteArraySet((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.emptyList(), Collection.class, "com.obric.memorydata.plugin"));
        this.f = new CopyOnWriteArraySet((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.emptyList(), Collection.class, "com.obric.memorydata.plugin"));
        this.g = new CopyOnWriteArraySet((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.emptyList(), Collection.class, "com.obric.memorydata.plugin"));
        this.h = new CopyOnWriteArraySet((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.emptyList(), Collection.class, "com.obric.memorydata.plugin"));
        this.i = new CopyOnWriteArraySet((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.emptyList(), Collection.class, "com.obric.memorydata.plugin"));
        this.j = new CopyOnWriteArraySet((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.emptyList(), Collection.class, "com.obric.memorydata.plugin"));
        this.k = 1000;
        this.l = new $$Lambda$a$IqTuuI9R9wD1sQCbVpbjceRSV6o(this);
        this.m = new $$Lambda$a$WdT3Hv4bY2DpXDNORxh5iUIPYIc(this);
        this.n = new $$Lambda$a$KbEEVDUVkHlQaKrdSTwQSlmSb8(this);
    }

    private final List<AppEntity> a(List<String> r9, int r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        if (r10 != 201) goto L5;
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r12.iterator();
    L16:
        if (r14.hasNext() == false) goto L20;
        Long r0 = StringsKt.toLongOrNull((String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin"));
        if (r0 == null) goto L16;
        r13.add(r0);
        goto L16
    L20:
        List r15 = (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin");
        f.f5867a.a("CallContentObserver", "queryEntities: " + r15);
        ContentResolver r16 = this.c.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r16, "getContentResolver(...)");
        List<AppEntity> r17 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(e.a(r16, r15, false, true), Collection.class, "com.obric.memorydata.plugin"));
        String r18 = e.a(this.c, r15);
        if (r18 == null) goto L24;
        f.f5867a.a("CallContentObserver", "queryEntities has profile: " + r18);
        ContentResolver r8 = this.c.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r8, "getContentResolver(...)");
        r17.addAll((Collection) ZeusTransformUtils.preCheckCast(e.a(r8, CollectionsKt.mutableListOf(new Long[]{Long.valueOf(Long.parseLong(r18))}), true, false), Collection.class, "com.obric.memorydata.plugin"));
    L24:
        return r17;
    L5:
        if (r10 != 202) goto L35;
        ContentResolver r19 = this.c.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r19, "getContentResolver(...)");
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r21 = r20.iterator();
    L9:
        if (r21.hasNext() == false) goto L36;
        Long r2 = StringsKt.toLongOrNull((String) ZeusTransformUtils.preCheckCast(r21.next(), String.class, "com.obric.memorydata.plugin"));
        if (r2 == null) goto L9;
        r1.add(r2);
        goto L9
    L36:
        return d.a(r19, (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), this.c);
    L35:
        return CollectionsKt.emptyList();
    }

    private static final void a(a r8) {
        Intrinsics.checkNotNullParameter(r8, "this$0");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r8.d, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        List<String> r0 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r8.d, Iterable.class, "com.obric.memorydata.plugin"));
        f.f5867a.a("CallContentObserver", "updateIndexRunnable: " + r0);
        r8.d.clear();
        List<AppEntity> r4 = d.a(r8.a(r0, 202));
        f.f5867a.a("CallContentObserver", "updateIndexRunnable CALL_HISTORY: " + r0 + ", after filter: " + r4.size());
        b.f5863a.a(r4);
    L6:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r8.e, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L9;
        List<String> r1 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r8.e, Iterable.class, "com.obric.memorydata.plugin"));
        r8.e.clear();
        List<AppEntity> r9 = r8.a(r1, 201);
        f.f5867a.a("CallContentObserver", "updateIndexRunnable CONTACT: " + r1 + ", after filter: " + r9.size());
        b.f5863a.a(r9);
        return;
    }

    private static final void b(a r6) {
        Intrinsics.checkNotNullParameter(r6, "this$0");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6.f, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        List<String> r0 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r6.f, Iterable.class, "com.obric.memorydata.plugin"));
        f.f5867a.a("CallContentObserver", "updateDeleteRunnable: " + r0);
        r6.f.clear();
        b.f5863a.a(r0, 201);
    L6:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6.g, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L9;
        List<String> r1 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r6.g, Iterable.class, "com.obric.memorydata.plugin"));
        f.f5867a.a("CallContentObserver", "updateDeleteRunnable: " + r1);
        r6.g.clear();
        b.f5863a.a(r1, 202);
        return;
    }

    private static final void c(a r3) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r3.j, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        List<? extends Uri> r0 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r3.j, Iterable.class, "com.obric.memorydata.plugin"));
        r3.j.clear();
        com.obric.contactsdk.d.f7853a.update(r0);
        return;
    }

    public static /* synthetic */ void lambda$IqTuuI9R9wD1sQCbVpbjceRSV6o(a r0) {
        a(r0);
    }

    /* JADX INFO: renamed from: lambda$KbEEVDUVkHlQaKrdSTwQS-lmSb8, reason: not valid java name */
    public static /* synthetic */ void m1lambda$KbEEVDUVkHlQaKrdSTwQSlmSb8(a r0) {
        c(r0);
    }

    public static /* synthetic */ void lambda$WdT3Hv4bY2DpXDNORxh5iUIPYIc(a r0) {
        b(r0);
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
        System.out.println("Error converting ids to list: " + e.getMessage());
        return r8;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r7, Uri r8) {
        super.onChange(r7, r8);
        String r9 = null;
        if (r8 == null) goto L5;
        String r0 = r8.getQueryParameter("domain");
    L6:
        if (r8 == null) goto L8;
        String r1 = r8.getQueryParameter("type");
    L9:
        if (r8 == null) goto L11;
        r9 = r8.getQueryParameter(OaidModel.KEY_ID);
    L11:
        f.f5867a.a("CallContentObserver", "onChange: " + r0 + ' ' + r1 + ' ' + r9 + ' ' + r8);
        if (r0 == null) goto L89;
        if (r1 == null) goto L100;
        if (r9 == null) goto L101;
        List<String> r10 = a(r9);
        if (Intrinsics.areEqual(r0, "calllog") == false) goto L19;
        char r2 = 202;
    L23:
        if (Intrinsics.areEqual(r1, "index") == false) goto L50;
        if (r2 != 202) goto L33;
        CopyOnWriteArraySet<String> r3 = this.d;
        monitor-enter(r3);
        this.d.addAll((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L30
        monitor-exit(r3);
    L30:
        th = move-exception;
        throw th;
    L33:
        if (r2 != 201) goto L42;
        CopyOnWriteArraySet<String> r4 = this.d;
        monitor-enter(r4);
        this.e.addAll((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L39
        monitor-exit(r4);
    L39:
        th = move-exception;
        throw th;
    L42:
        Handler r11 = g.f7856a.a();
        if (r11 == null) goto L45;
        r11.removeCallbacks(this.l);
    L45:
        Handler r12 = g.f7856a.a();
        if (r12 == null) goto L75;
        Runnable r5 = this.l;
    L48:
        r12.postDelayed(r5, this.k);
    L75:
        if (r2 != 201) goto L102;
        CopyOnWriteArraySet<Uri> r13 = this.j;
        monitor-enter(r13);
        this.j.add(r8);     // Catch: Throwable -> L86
        monitor-exit(r13);
        Handler r14 = g.f7856a.a();
        if (r14 == null) goto L83;
        r14.removeCallbacks(this.n);
    L83:
        Handler r15 = g.f7856a.a();
        if (r15 == null) goto L103;
        r15.postDelayed(this.n, this.k);
        return;
    L103:
        return;
    L86:
        th = move-exception;
        throw th;
    L102:
        return;
    L50:
        if (Intrinsics.areEqual(r1, "delete") == false) goto L75;
        if (r2 != 202) goto L60;
        CopyOnWriteArraySet<String> r6 = this.g;
        monitor-enter(r6);
        this.g.addAll((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L57
        monitor-exit(r6);
    L57:
        th = move-exception;
        throw th;
    L60:
        if (r2 != 201) goto L69;
        CopyOnWriteArraySet<String> r16 = this.f;
        monitor-enter(r16);
        this.f.addAll((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L66
        monitor-exit(r16);
    L66:
        th = move-exception;
        throw th;
    L69:
        Handler r17 = g.f7856a.a();
        if (r17 == null) goto L72;
        r17.removeCallbacks(this.m);
    L72:
        r12 = g.f7856a.a();
        if (r12 == null) goto L75;
        r5 = this.m;
        goto L48
    L19:
        if (Intrinsics.areEqual(r0, "contacts") == false) goto L21;
        r2 = 201;
        goto L23
    L21:
        r2 = 0;
        goto L23
    L101:
        return;
    L100:
        return;
    L89:
        return;
    L8:
        r1 = null;
        goto L9
    L5:
        r0 = null;
        goto L6
    }
}
