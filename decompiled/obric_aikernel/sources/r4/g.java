package r4;

/* JADX INFO: loaded from: classes.dex */
public class g extends com.bytedance.retrofit2.mime.c {
    public g(String r10) {
        super("text/plain; charset=UTF-8", k(r10), new String[0]);
    }

    private static byte[] k(String r10) {
        return r10.getBytes("UTF-8");
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // com.bytedance.retrofit2.mime.c
    public String toString() {
        return "TypedString[" + new String(j(), "UTF-8") + "]";
    L5:
        throw new AssertionError("Must be able to decode UTF-8");
    }
}
