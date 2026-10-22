package kpb;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface a {

    /* JADX INFO: renamed from: kpb.a$a, reason: collision with other inner class name */
    public interface InterfaceC0291a extends b {
    }

    public interface b {
        String getString(String r1, String r2);

        void putString(String r1, String r2);

        void remove(String r1);
    }

    public interface c extends b {
    }

    InterfaceC0291a getLarkRepo();

    c getUserRepo();
}
