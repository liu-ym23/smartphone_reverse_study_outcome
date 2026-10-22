package d3;

import com.bytedance.apm6.util.constant.NetConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class f extends c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<String> f8470i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<String> f8471j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f8472k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f8473l;

    static {
    }

    public f(int r10) {
        super(r10);
        this.f8470i = new ArrayList();
        this.f8471j = new ArrayList();
        this.f8472k = false;
        this.f8473l = false;
    }

    @Override // d3.c
    protected boolean b(n4.c r10, Map<String, List<String>> r11) {
        if (this.f8472k == false) goto L5;
    L44:
        return false;
    L5:
        if (h(r10) == false) goto L44;
        if (r11.isEmpty() == false) goto L11;
        return false;
    L11:
        if (this.f8470i.isEmpty() == true) goto L23;
        Map<? extends String, ? extends List<String>> r12 = new LinkedHashMap();
        if (r11.containsKey("x-tt-encrypt-queries") == false) goto L15;
        r12.put("x-tt-encrypt-queries", r11.get("x-tt-encrypt-queries"));
    L15:
        Iterator<String> r13 = this.f8470i.iterator();
    L17:
        if (r13.hasNext() == false) goto L21;
        String r14 = r13.next();
        if (r11.containsKey(r14) == false) goto L17;
        r12.put(r14, r11.get(r14));
        goto L17
    L21:
        r11.clear();
        r11.putAll(r12);
        return true;
    L23:
        if (this.f8471j.isEmpty() == true) goto L55;
        Iterator<String> r15 = this.f8471j.iterator();
    L26:
        if (r15.hasNext() == false) goto L29;
        r11.remove(r15.next());
        goto L26
    L29:
        if (r10.G() == null) goto L31;
        String r16 = r10.G();
    L33:
        if (this.f8473l == true) goto L35;
        return true;
    L35:
        if (r16.contains("bgrm") == true) goto L57;
        Iterator<String> r17 = this.f8471j.iterator();
    L38:
        if (r17.hasNext() == false) goto L58;
        if (r16.contains(r17.next()) == false) goto L38;
        ArrayList r18 = new ArrayList();
        r18.add(NetConst.ENCRYPT_VERISON_CODE);
        r11.put("bgrm", r18);
        return true;
    L58:
        return true;
    L57:
        return true;
    L31:
        r16 = "";
        goto L33
    L55:
        return true;
    }

    @Override // d3.c
    protected void i(JSONObject r10) {
        j(r10);
        d.i(r10.optJSONArray("keep_list"), this.f8470i);
        d.i(r10.optJSONArray("remove_list"), this.f8471j);
        boolean r11 = false;
        if (r10.optInt("protect_background_request", 0) <= 0) goto L5;
        boolean r12 = true;
    L6:
        this.f8456c = r12;
        if (r10.optInt("add_background_rm_mark", 0) <= 0) goto L9;
        r11 = true;
    L9:
        this.f8473l = r11;
        if (this.f8470i.isEmpty() == false) goto L12;
        return;
    L12:
        if (this.f8471j.isEmpty() == true) goto L16;
        this.f8472k = true;
        return;
    L16:
        return;
    L5:
        r12 = false;
        goto L6
    }
}
