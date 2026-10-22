package com.lynx.clay.embedding.engine.plugins.audio.soundpool;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface GenericSoundPool {

    public static abstract enum Types extends Enum<Types> {
        public static final Types COMPACT = null;
        public static final Types SYSTEM = null;
        public static final /* synthetic */ Types[] a = null;

        public Types() {
            throw null;
        }

        public abstract GenericSoundPool create(Context r1);

        static {
            final String r1 = "SYSTEM";
            final int r2 = 0;
            Types r0 = new AnonymousClass1(r1, r2);
            SYSTEM = r0;
            final String r3 = "COMPACT";
            final int r4 = 1;
            Types r5 = new AnonymousClass2(r3, r4);
            COMPACT = r5;
            a = new Types[]{r0, r5};
        }

        public static Types[] values() {
            return (Types[]) a.clone();
        }

        public static Types valueOf(String r1) {
            return (Types) r27.a.a(Types.class, r1);
        }

        public Types(String r1, int r2, a r3) {
            super(r1, r2);
        }
    }

    public static /* synthetic */ class a {
    }

    public interface b {
    }

    void a();

    void b(com.lynx.clay.embedding.engine.plugins.audio.a.C0036a r1);

    void c(int r1, int r2);

    int d(int r1, float r2, float r3, int r4);

    void e(int r1, float r2, float r3);

    void f();

    int load(String r1);

    void pause(int r1);

    void release();

    void resume(int r1);

    void stop(int r1);
}
