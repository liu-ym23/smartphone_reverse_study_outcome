package ra1;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002\n\u001dB\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lra1/g;", "", "", "sugType", "Ljava/lang/String;", "getSugType", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "content", "a", "e", "", "Lra1/d;", "position", "Ljava/util/List;", "c", "()Ljava/util/List;", "setPosition", "(Ljava/util/List;)V", "Lra1/g$b;", "wordRecord", "Lra1/g$b;", "getWordRecord", "()Lra1/g$b;", "setWordRecord", "(Lra1/g$b;)V", "<init>", "()V", "b", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {
    public static final /* synthetic */ int b = 0;
    public boolean a;

    @SerializedName("content")
    private String content;

    @SerializedName("pos")
    private List<d> position;

    @SerializedName("sug_type")
    private String sugType;

    @SerializedName("word_record")
    private b wordRecord;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0018"}, d2 = {"Lra1/g$b;", "", "", "groupId", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "", "position", "I", "b", "()I", "setPosition", "(I)V", "wordSource", "d", "setWordSource", "wordContent", "c", "setWordContent", "<init>", "()V", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("group_id")
        private String groupId;

        @SerializedName("words_position")
        private int position;

        @SerializedName("words_content")
        private String wordContent;

        @SerializedName("words_source")
        private String wordSource;

        public b() {
            this.groupId = "";
            this.wordSource = "";
            this.wordContent = "";
        }

        public final String a() {
            return this.groupId;
        }

        public final int b() {
            return this.position;
        }

        public final String c() {
            return this.wordContent;
        }

        public final String d() {
            return this.wordSource;
        }
    }

    static {
    }

    public final Map<String, String> b() {
        HashMap r0 = new HashMap();
        b r1 = this.wordRecord;
        String r2 = "";
        if (r1 == null) goto L6;
        String r3 = r1.c();
        if (r3 == null) goto L6;
    L7:
        r0.put("words_content", r3);
        b r4 = this.wordRecord;
        if (r4 == null) goto L11;
        String r5 = String.valueOf(r4.b());
        if (r5 == null) goto L11;
    L12:
        r0.put("words_position", r5);
        b r6 = this.wordRecord;
        if (r6 == null) goto L16;
        String r7 = r6.a();
        if (r7 == null) goto L16;
    L17:
        r0.put("group_id", r7);
        b r8 = this.wordRecord;
        if (r8 == null) goto L23;
        String r9 = r8.d();
        if (r9 == null) goto L23;
        r2 = r9;
    L23:
        r0.put("wordSource", r2);
        return r0;
    L16:
        r7 = "";
    L11:
        r5 = "";
    L6:
        r3 = "";
        goto L7
    }

    public final boolean d() {
        return TextUtils.equals(this.sugType, "history");
    }

    public final void f() {
        Intrinsics.checkNotNullParameter("history", "<set-?>");
        this.sugType = "history";
    }

    public g() {
        this.sugType = "";
        this.content = "";
    }

    public final String a() {
        return this.content;
    }

    public final List<d> c() {
        return this.position;
    }

    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.content = r2;
    }
}
