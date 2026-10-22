package uk8;

import com.larus.bmhome.chat.standarduikit.elapsedblock.viewmodel.ElapsedBlockStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public String a;
    public boolean b;
    public boolean c;
    public ElapsedBlockStatus d;
    public ib8.c e;

    /* JADX INFO: renamed from: uk8.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0135a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ElapsedBlockStatus.values().length];
            r0[ElapsedBlockStatus.Folded.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ElapsedBlockStatus.Expanded.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public a() {
        this.d = ElapsedBlockStatus.Folded;
        this.e = new ib8.c(true, null, null, 14);
    }
}
