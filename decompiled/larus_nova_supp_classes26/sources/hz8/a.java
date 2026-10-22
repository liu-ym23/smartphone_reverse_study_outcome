package hz8;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.o2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final String a;
    public final int b;
    public final Keva c;
    public final List<String> d;

    /* JADX INFO: renamed from: hz8.a$a, reason: collision with other inner class name */
    public static final class C0113a {
    }

    static {
    }

    public final void b() {
        ((ArrayList) this.d).clear();
        this.c.storeString(this.a, "");
    }

    public /* synthetic */ a(String r2) {
        this(r2, 10);
    }

    public final void a(String r11) {
        Intrinsics.checkNotNullParameter(r11, "newItem");
        if (r11.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (StringsKt.isBlank(r11) == false) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r11, CollectionsKt.getOrNull(this.d, 0)) == false) goto L14;
        return;
    L14:
        if (((ArrayList) this.d).contains(r11) == false) goto L16;
        ((ArrayList) this.d).remove(r11);
    L16:
        ListProtector.add(this.d, 0, r11);
        if (((ArrayList) this.d).size() <= this.b) goto L19;
        List<String> r12 = this.d;
        ListProtector.remove(r12, ((ArrayList) r12).size() - 1);
    L19:
        this.c.storeString(this.a, CollectionsKt.joinToString$default(this.d, ",", null, null, 0, null, null, 62, null));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void c(String r11) {
        Intrinsics.checkNotNullParameter(r11, "item");
        ((ArrayList) this.d).remove(r11);
        this.c.storeString(this.a, CollectionsKt.joinToString$default(this.d, ",", null, null, 0, null, null, 62, null));
    }

    public a(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "searchKey");
        this.a = r10;
        this.b = r11;
        Keva r12 = Keva.getRepo(AccountService.a.getSecUserId() + '_' + o2.a.e(), 0);
        this.c = r12;
        ArrayList r1 = new ArrayList();
        this.d = r1;
        List r13 = StringsKt.split$default(r12.getString(r10, ""), new char[]{','}, false, 0, 6, null);
        ArrayList r2 = new ArrayList();
        Iterator r14 = r13.iterator();
    L4:
        if (r14.hasNext() == false) goto L11;
        Object r3 = r14.next();
        if (((String) r3).length() <= 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L4;
        r2.add(r3);
        goto L4
    L8:
        r4 = false;
        goto L9
    L11:
        r1.addAll(r2);
    }
}
