package gx8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface e {

    public static final class a {
        public static String a(e r2) {
            return r2.getEventType() + r2.getUploadName();
        }
    }

    String getEventType();

    String getUniqueKey();

    String getUploadName();
}
