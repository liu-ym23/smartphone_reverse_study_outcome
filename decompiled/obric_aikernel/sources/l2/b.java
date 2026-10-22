package l2;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeInfo;
import com.bytedance.common.utility.Logger;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.frameworks.baselib.network.http.util.k;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import l2.c;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class b<T extends c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final AtomicBoolean f10873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Pair<a, T>> f10874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private T f10875c;

    public b() {
        this.f10873a = new AtomicBoolean(false);
        this.f10874b = new CopyOnWriteArrayList();
    }

    public abstract String a();

    public T b(String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L5;
    L104:
        return null;
    L5:
        if (this.f10873a.get() == false) goto L104;
        Uri r12 = Uri.parse(r11);
        if (r12 != null) goto L10;
        return null;
    L10:
        String r10 = r12.getHost();
        String r13 = r12.getPath();
        if (TextUtils.isEmpty(r10) == true) goto L104;
        if (TextUtils.isEmpty(r13) == true) goto L104;
        Iterator<Pair<a, T>> r14 = this.f10874b.iterator();
    L17:
        if (r14.hasNext() == false) goto L100;
        Pair<a, T> r15 = r14.next();
        if (r15 == null) goto L17;
        a r16 = (a) r15.first;
        if (r16 == null) goto L17;
        Set<String> r17 = r16.f10867a;
        boolean r18 = false;
        boolean r19 = true;
        if (r17 != null) goto L27;
    L32:
        boolean r20 = false;
    L33:
        if (r20 == true) goto L45;
        Set<String> r21 = r16.f10868b;
        if (r21 == null) goto L45;
        Iterator<String> r22 = r21.iterator();
    L38:
        if (r22.hasNext() == false) goto L45;
        if (k.i(r10, r22.next()) == false) goto L38;
        if (Logger.debug() == false) goto L44;
        Logger.d("TTHostPathMatchRule", "hitRule: host_wc.");
    L44:
        r20 = true;
    L45:
        if (r20 == false) goto L100;
        Set<String> r23 = r16.f10869c;
        if (r23 != null) goto L50;
    L55:
        if (r18 == true) goto L67;
        Set<String> r24 = r16.f10870d;
        if (r24 == null) goto L67;
        Iterator<String> r25 = r24.iterator();
    L60:
        if (r25.hasNext() == false) goto L67;
        if (r13.startsWith(r25.next()) == false) goto L60;
        if (Logger.debug() == false) goto L66;
        Logger.d("TTHostPathMatchRule", "hitRule: path_prefix.");
    L66:
        r18 = true;
    L67:
        if (r18 == true) goto L79;
        Set<String> r26 = r16.f10871e;
        if (r26 == null) goto L79;
        Iterator<String> r27 = r26.iterator();
    L72:
        if (r27.hasNext() == false) goto L79;
        if (r13.contains(r27.next()) == false) goto L72;
        if (Logger.debug() == false) goto L78;
        Logger.d("TTHostPathMatchRule", "hitRule: path_contain.");
    L78:
        r18 = true;
    L79:
        if (r18 == true) goto L94;
        Set<Pattern> r28 = r16.f10872f;
        if (r28 == null) goto L94;
        Iterator<Pattern> r29 = r28.iterator();
    L84:
        if (r29.hasNext() == false) goto L94;
        Pattern r30 = r29.next();
        if (r30 == null) goto L84;
        if (r30.matcher(r13).matches() == false) goto L84;
    L93:
        r18 = true;
        goto L84
    L90:
        if (Logger.debug() == false) goto L95;
        Logger.d("TTHostPathMatchRule", "hitRule: path_pattern.");     // Catch: Throwable -> L93
    L95:
        if (r19 == false) goto L17;
        return (T) r15.second;
    L94:
        r19 = r18;
        goto L95
    L50:
        if (r23.contains(r13) == false) goto L55;
        if (Logger.debug() == false) goto L54;
        Logger.d("TTHostPathMatchRule", "hitRule: path_eq.");
    L54:
        r18 = true;
        goto L55
    L27:
        if (r17.contains(r10) == false) goto L32;
        if (Logger.debug() == false) goto L31;
        Logger.d("TTHostPathMatchRule", "hitRule: host_eq.");
    L31:
        r20 = true;
    L100:
        if (Logger.debug() == false) goto L103;
        Logger.d("TTHostPathMatchRule", "use default config");
    L103:
        return this.f10875c;
    }

    public List<Pair<a, T>> c() {
        return this.f10874b;
    }

    public boolean d() {
        return this.f10873a.get();
    }

    public abstract T e(Object r10);

    protected Set<String> f(JSONArray r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.length() == 0) goto L19;
        HashSet r11 = new HashSet();
        int r12 = 0;
    L8:
        if (r12 >= r10.length()) goto L13;
        String r13 = r10.optString(r12);
        if (TextUtils.isEmpty(r13) == true) goto L12;
        r11.add(r13);
    L12:
        r12 = r12 + 1;
        goto L8
    L13:
        return r11;
    L19:
        return null;
    }

    boolean g(JSONObject r10) {
        return true;
    }

    public boolean h(JSONObject r10) {
        int r11 = 0;
        this.f10873a.set(false);
        this.f10874b.clear();
        if (r10 != null) goto L5;
    L93:
        return false;
    L5:
        if (r10.length() == 0) goto L93;
        JSONObject r12 = r10.optJSONObject(a());
        if (r12 != null) goto L10;
    L92:
        return true;
    L10:
        if (r12.length() == 0) goto L92;
        AtomicBoolean r13 = this.f10873a;
        if (r12.optInt("enabled", 0) <= 0) goto L15;
        boolean r14 = true;
    L16:
        r13.set(r14);
        if (this.f10873a.get() == true) goto L20;
        return true;
    L20:
        if (g(r12) == true) goto L22;
        return false;
    L22:
        Object r15 = r12.opt(DowngradeInfo.SubInfo.FIELD_DEFAULT_RATE);
        if (r15 == null) goto L25;
        this.f10875c = (T) e(r15);
    L25:
        JSONArray r16 = r12.optJSONArray("rule_list");
        if (r16 != null) goto L28;
    L91:
        return false;
    L28:
        if (r16.length() == 0) goto L91;
    L31:
        if (r11 >= r16.length()) goto L90;
        JSONObject r17 = r16.optJSONObject(r11);
        if (r17 == null) goto L89;
        if (r17.length() == 0) goto L89;
        a r18 = new a();
        r18.f10867a = f(r17.optJSONArray("host_eq"));
        r18.f10868b = f(r17.optJSONArray("host_wc"));
        Set<String> r19 = r18.f10867a;
        if (r19 != null) goto L40;
    L41:
        Set<String> r20 = r18.f10868b;
        if (r20 == null) goto L86;
        if (r20.isEmpty() == true) goto L86;
    L46:
        r18.f10869c = f(r17.optJSONArray("path_eq"));
        r18.f10870d = f(r17.optJSONArray("path_prefix"));
        r18.f10871e = f(r17.optJSONArray("path_contain"));
        Set<String> r21 = f(r17.optJSONArray("path_pattern"));
        if (r21 == null) goto L54;
        r18.f10872f = new HashSet();
        Iterator<String> r22 = r21.iterator();
    L50:
        if (r22.hasNext() == false) goto L54;
        r18.f10872f.add(Pattern.compile(r22.next()));     // Catch: Throwable -> L94
    L54:
        Set<String> r23 = r18.f10869c;
        if (r23 != null) goto L57;
    L58:
        Set<String> r24 = r18.f10870d;
        if (r24 != null) goto L61;
    L62:
        Set<String> r25 = r18.f10871e;
        if (r25 != null) goto L65;
    L66:
        Set<Pattern> r26 = r18.f10872f;
        if (r26 == null) goto L83;
        if (r26.isEmpty() == true) goto L83;
    L71:
        Object r27 = r17.opt(EventBody.KEY_VALUE);
        if (r27 == null) goto L74;
        c r28 = e(r27);
        if (r28 == null) goto L79;
        TextUtils.isEmpty(r17.optString("sign"));
        this.f10874b.add(new Pair(r18, r28));
        goto L89
    L79:
        if (Logger.debug() == false) goto L89;
        String r29 = "ParseHostPathValue failed.";
    L88:
        Logger.d("TTHostPathMatchRule", r29);
        goto L89
    L74:
        if (Logger.debug() == false) goto L89;
        r29 = "value is null.";
    L83:
        if (Logger.debug() == false) goto L89;
        r29 = "no path filter exist.";
        goto L88
    L65:
        if (r25.isEmpty() == false) goto L71;
    L61:
        if (r24.isEmpty() == false) goto L71;
    L57:
        if (r23.isEmpty() == false) goto L71;
    L86:
        if (Logger.debug() == false) goto L89;
        r29 = "both host_eq and host_wc empty.";
        goto L88
    L40:
        if (r19.isEmpty() == false) goto L46;
    L89:
        r11 = r11 + 1;
        goto L31
    L90:
        return true;
    L15:
        r14 = false;
        goto L16
    }

    public void i(boolean r10) {
        this.f10873a.set(r10);
    }
}
