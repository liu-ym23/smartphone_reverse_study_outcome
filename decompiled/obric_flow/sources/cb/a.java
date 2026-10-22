package cb;

import com.bytedance.gkfs.d;
import com.lynx.tasm.base.h;
import com.lynx.tasm.p;
import com.lynx.tasm.utils.g;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Unit;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Iterable, KMappedMarker {
    public static final LinkedList d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f1166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList f1167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1168c;

    static {
        d = new LinkedList();
    }

    public a(int r10) {
        this.f1168c = r10;
        this.f1166a = new d();
        LinkedList r5 = new LinkedList();
        int r11 = r10 / 4096;
        int r12 = 0;
        if ((r10 % 4096) != 0) goto L5;
        int r13 = 0;
    L6:
        int r14 = r11 + r13;
    L7:
        if (r12 >= r14) goto L20;
        if (r12 != (r14 - 1)) goto L18;
        int r15 = this.f1168c % 4096;
        Integer r16 = Integer.valueOf(r15);
        if (r15 != 0) goto L14;
        r16 = null;
    L14:
        if (r16 == null) goto L16;
        int r17 = r16.intValue();
    L17:
        r5.add(g.g(r17));
    L19:
        r12 = r12 + 1;
        goto L7
    L16:
        r17 = 4096;
        goto L17
    L18:
        r5.add(g.g(4096));
        goto L19
    L20:
        this.f1167b = r5;
        return;
    L5:
        r13 = 1;
        goto L6
    }

    public static /* synthetic */ void d(a r5, a r10, int r11, int r12, int r13) {
        if ((r13 & 2) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 8) == 0) goto L8;
        r12 = r5.f1168c;
    L8:
        r5.c(r10, r11, r12);
    }

    public final void b(int r10, byte[] r11, int r12, int r13) {
        if ((r10 + r13) > r11.length) goto L17;
        if ((r12 + r13) > this.f1168c) goto L15;
        int r5 = r12 / 4096;
        LinkedList r14 = this.f1167b;
        int r15 = r14.size();
        int r16 = 0;
    L7:
        if (r5 >= r15) goto L11;
        if (r16 >= r13) goto L11;
        int r17 = (r12 + r16) % 4096;
        int r18 = Math.min(((byte[]) r14.get(r5)).length - r17, r13 - r16);
        System.arraycopy(r11, r10 + r16, r14.get(r5), r17, r18);
        r16 = r16 + r18;
        r5 = r5 + 1;
    L11:
        if (r16 == r13) goto L20;
        d.f(this.f1166a, "SegmentalByteArray", h.b(r13, r16, "except copy ", " bytes but only copied "), 0, 28);
        return;
    L20:
        return;
    L15:
        throw new IndexOutOfBoundsException("copy length larger than available size of dest!");
    L17:
        throw new IndexOutOfBoundsException("copy length larger than available size of src!");
    }

    public final void c(a r10, int r11, int r12) {
        int r5 = this.f1168c;
        if (r12 > r5) goto L12;
        LinkedList r13 = this.f1167b;
        int r14 = r13.size();
        int r15 = 0;
        int r16 = 0;
    L5:
        if (r15 >= r14) goto L9;
        if (r16 >= r12) goto L9;
        int r17 = r16 % 4096;
        int r18 = Math.min(((byte[]) r13.get(r15)).length - r17, r12 - r16);
        r10.b(r17, (byte[]) r13.get(r15), r11 + r16, r18);
        r16 = r16 + r18;
        r15 = r15 + 1;
    L9:
        if (r16 == r12) goto L16;
        d.f(this.f1166a, "SegmentalByteArray", h.b(r12, r16, "except copy ", " bytes but only copied "), 0, 28);
        return;
    L16:
        return;
    L12:
        StringBuilder r19 = p.d(r12, "endIndex ", " larger than array size ");
        r19.append(r5);
        throw new IndexOutOfBoundsException(r19.toString());
    }

    public final void finalize() {
        Iterator r5 = this.f1167b.iterator();
    L4:
        if (r5.hasNext() == false) goto L20;
        byte[] r10 = (byte[]) r5.next();
        if (r10.length != 4096) goto L4;
        LinkedList r11 = d;
        monitor-enter(r11);
        if (r11.size() >= 125) goto L15;
        Arrays.fill(r10, (byte) 0);     // Catch: Throwable -> L13
        r11.offer(r10);     // Catch: Throwable -> L13
    L15:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r11);
    L13:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f1167b.iterator();
    }
}
