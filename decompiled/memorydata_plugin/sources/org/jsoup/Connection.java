package org.jsoup;

import com.bytedance.retrofit2.HttpMethodContrants;
import com.bytedance.security.dbcipher.utils.CipherConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public interface Connection {

    public static final enum Method extends Enum<Method> {
        private static final /* synthetic */ Method[] $VALUES = null;
        public static final Method DELETE = null;
        public static final Method GET = null;
        public static final Method HEAD = null;
        public static final Method OPTIONS = null;
        public static final Method PATCH = null;
        public static final Method POST = null;
        public static final Method PUT = null;
        public static final Method TRACE = null;
        private final boolean hasBody;

        private static /* synthetic */ Method[] $values() {
            return new Method[]{GET, POST, PUT, DELETE, PATCH, HEAD, OPTIONS, TRACE};
        }

        static {
            GET = new Method(HttpMethodContrants.GET, 0, false);
            POST = new Method("POST", 1, true);
            PUT = new Method(HttpMethodContrants.PUT, 2, true);
            DELETE = new Method(HttpMethodContrants.DELETE, 3, false);
            PATCH = new Method(HttpMethodContrants.PATCH, 4, true);
            HEAD = new Method(HttpMethodContrants.HEAD, 5, false);
            OPTIONS = new Method(HttpMethodContrants.OPTIONS, 6, false);
            TRACE = new Method(CipherConst.LEVEL_TRACE, 7, false);
            $VALUES = $values();
        }

        private Method(String r1, int r2, boolean r3) {
            super(r1, r2);
            this.hasBody = r3;
        }

        public static Method valueOf(String r2) {
            return (Method) ZeusTransformUtils.preCheckCast(Enum.valueOf(Method.class, r2), Method.class, "com.obric.memorydata.plugin");
        }

        public static Method[] values() {
            return (Method[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Method[].class, "com.obric.memorydata.plugin");
        }

        public final boolean hasBody() {
            return this.hasBody;
        }
    }
}
