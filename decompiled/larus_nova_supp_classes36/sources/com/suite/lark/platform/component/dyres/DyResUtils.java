package com.suite.lark.platform.component.dyres;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.entity.LoadParams;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class DyResUtils {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/suite/lark/platform/component/dyres/DyResUtils$ResI18n;", "", "Companion", "dyres_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ResI18n {
        public static final a Companion = null;
        public static final String de_DE = "de_DE";
        public static final String en_US = "en_US";
        public static final String es_ES = "es_ES";
        public static final String fr_FR = "fr_FR";
        public static final String hi_IN = "hi_IN";
        public static final String in = "in";
        public static final String it_IT = "it_IT";
        public static final String ja_JP = "ja_JP";
        public static final String ko_KR = "ko_KR";
        public static final String pt_BR = "pt_BR";
        public static final String ru_RU = "ru_RU";
        public static final String th_TH = "th_TH";
        public static final String vi_VN = "vi_VN";
        public static final String zh_CN = "zh_CN";

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }

            public static List a() {
                return CollectionsKt.listOf(new String[]{ResI18n.zh_CN, ResI18n.en_US, ResI18n.ja_JP, ResI18n.de_DE, ResI18n.es_ES, ResI18n.fr_FR, ResI18n.hi_IN, ResI18n.in, ResI18n.it_IT, ResI18n.ko_KR, ResI18n.pt_BR, ResI18n.ru_RU, ResI18n.th_TH, ResI18n.vi_VN});
            }
        }

        static {
            Companion = a.a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/suite/lark/platform/component/dyres/DyResUtils$ResType;", "", "Companion", "dyres_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ResType {
        public static final a Companion = null;
        public static final int IMAGE = 2;
        public static final int TEXT = 1;
        public static final int UNKNOWN = 0;
        public static final int VIDEO = 3;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    public static final class a {
        public static String a(Locale r3) {
            StringBuilder r0 = new StringBuilder();
            r0.append(r3.getLanguage().toLowerCase());
            if (r3.getCountry().length() != 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L8;
            String r4 = "";
        L9:
            r0.append(r4);
            return r0.toString();
        L8:
            r4 = "_" + r3.getCountry().toUpperCase();
            goto L9
        L5:
            r1 = false;
            goto L6
        }
    }

    public interface b {
        public static final a a = null;

        public static final class a {
            public static final /* synthetic */ a a = null;
            public static b b;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            a = a.a;
        }
    }

    public static final class c {
        public static final /* synthetic */ int c = 0;
        public int a;
        public final HashMap<String, String> b;

        public static final class a {
            public static c a(JSONObject r8) {
                Intrinsics.checkNotNullParameter("upload_contacts_max_num", "valueKey");
                Intrinsics.checkNotNullParameter(r8, "obj");
                JSONObject r2 = r8.optJSONObject("value");     // Catch: JSONException -> L40
                if (r2 != null) goto L6;
                return null;
            L6:
                String r9 = r8.optString("type");     // Catch: JSONException -> L40
                c r3 = new c();     // Catch: JSONException -> L40
                ResType.a r4 = ResType.Companion;     // Catch: JSONException -> L40
                Intrinsics.checkNotNull(r9);     // Catch: JSONException -> L40
                r4.getClass();     // Catch: JSONException -> L40
                Intrinsics.checkNotNullParameter(r9, "value");     // Catch: JSONException -> L40
                int r0 = r9.hashCode();     // Catch: JSONException -> L40
                if (r0 == 3556653) goto L22;
                if (r0 == 100313435) goto L18;
                if (r0 == 112202875) goto L14;
            L23:
                int r10 = 0;
            L25:
                r3.a = r10;     // Catch: JSONException -> L40
                ResI18n.Companion.getClass();     // Catch: JSONException -> L40
                Iterator r11 = ResI18n.a.a().iterator();     // Catch: JSONException -> L40
            L26:
                if (r11.hasNext() == false) goto L39;
                String r1 = (String) r11.next();     // Catch: JSONException -> L40
                String r5 = r2.optString(r1);     // Catch: JSONException -> L40
                if (r5 != null) goto L31;
            L34:
                boolean r7 = true;
            L35:
                if (r7 == true) goto L26;
                r3.b.put(r1, r5);     // Catch: JSONException -> L40
                goto L26
            L31:
                if (r5.length() == 0) goto L34;
                r7 = false;
                goto L35
            L39:
                return r3;
            L14:
                if (r9.equals("video") == false) goto L23;
                r10 = 3;
                goto L25
            L18:
                if (r9.equals(LoadParams.ImageFormat.IMAGE) == false) goto L23;
                r10 = 2;
                goto L25
            L22:
                if (r9.equals("text") == false) goto L23;
                r10 = 1;
            L40:
                return null;
            }
        }

        static {
        }

        public c() {
            this.b = new HashMap();
        }

        public final int getType() {
            return this.a;
        }
    }

    static {
    }
}
