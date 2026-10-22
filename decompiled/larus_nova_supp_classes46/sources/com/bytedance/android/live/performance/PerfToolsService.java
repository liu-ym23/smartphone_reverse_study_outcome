package com.bytedance.android.live.performance;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.WindowManager;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.performance.adapter.DebugNormalInfoAdapter;
import com.bytedance.android.live.performance.adapter.DebugPerformanceTextAdapter;
import com.bytedance.android.live.performance.api.IPerfToolsService;
import com.bytedance.android.live.performance.views.charts.LineChartView;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import org.json.JSONObject;
import sr0.i;
import vr0.a;
import wr0.b;
import wr0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class PerfToolsService implements IPerfToolsService {
    private i mPresenter;

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public void clearSceneInfo() {
        Iterator<String> r0 = b.b.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        String r1 = r0.next();
        HashMap<String, b.a> r2 = b.b;
        b.a r3 = r2.get(r1);
        if (r3 == null) goto L4;
        if (r3.d != 1) goto L4;
        HashMap<String, String> r4 = r3.b;
        if (r4 == null) goto L12;
        r4.clear();
    L12:
        r2.remove(r1);
        b.j(r1, false);
        goto L4
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public void dismiss() {
        i r0 = this.mPresenter;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a();
        r0.b();
        r0.x = null;
        r0.u = null;
        r0.a = null;
        b.b();
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public int getCurrentEntrance() {
        i r0 = this.mPresenter;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.y;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public int getCurrentPerformanceType() {
        i r0 = this.mPresenter;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.z;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public boolean isContentVisible() {
        i r0 = this.mPresenter;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.g == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public boolean isNormalViewVisible() {
        i r0 = this.mPresenter;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.d() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public boolean isPerformanceViewVisible() {
        i r0 = this.mPresenter;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.e() == false) goto L7;
        return true;
    }

    public PerfToolsService() {
        k.l(IPerfToolsService.class, this);
        this.mPresenter = new i();
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public void verifyEntranceNormalData() {
        if (c.a() == false) goto L70;
        i r0 = this.mPresenter;
        if (r0 == null) goto L76;
        r0.getClass();
        ArrayList r1 = new ArrayList();
        if (r0.y != 4) goto L15;
        if (r0.s != null) goto L12;
    L19:
        int r2 = this.mPresenter.y;
        IPerfToolsService r3 = b.a;
        if (r1.isEmpty() == false) goto L23;
    L47:
        i r4 = this.mPresenter;
        if (r4.y != 4) goto L55;
        if (r4.s != null) goto L52;
        return;
    L52:
        if (r4.e() == false) goto L72;
        DebugPerformanceTextAdapter r5 = r4.s;
        ((ArrayList) r5.b).clear();
        ((ArrayList) r5.b).addAll(r1);
        r5.notifyDataSetChanged();
        return;
    L72:
        return;
    L55:
        if (r4.l != null) goto L57;
        return;
    L57:
        if (r4.d() == false) goto L75;
        DebugNormalInfoAdapter r6 = r4.l;
        ((ArrayList) r6.b).clear();
        ((ArrayList) r6.b).addAll(r1);
        r6.notifyDataSetChanged();
        return;
    L75:
        return;
    L23:
        if (r2 != 1) goto L29;
        if (b.i() == false) goto L27;
        r2 = 9;
    L36:
        List<String> r7 = b.c.get(Integer.valueOf(r2));
        if (r7 == null) goto L47;
        if (r7.isEmpty() == true) goto L47;
        Iterator r8 = r1.iterator();
    L43:
        if (r8.hasNext() == false) goto L47;
        if (r7.contains(((a) r8.next()).a) == true) goto L43;
        r8.remove();
        goto L43
    L27:
        r2 = 10;
        goto L36
    L29:
        if (r2 != 2) goto L36;
        Iterator r9 = r1.iterator();
    L32:
        if (r9.hasNext() == false) goto L47;
        if (b.a(((a) r9.next()).a) == true) goto L32;
        r9.remove();
        goto L32
    L12:
        if (r0.e() == false) goto L19;
        r1.addAll(r0.s.b);
        goto L19
    L15:
        if (r0.l == null) goto L19;
        if (r0.d() == false) goto L19;
        r1.addAll(r0.l.b);
        goto L19
    L76:
        return;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public void clearDynamicData() {
        b.b();
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public void addClientInfoKey(JSONObject r7) {
        if (r7 != null) goto L4;
        IPerfToolsService r8 = b.a;
        return;
    L4:
        if (b.f == false) goto L17;
        HashMap<Integer, List<String>> r0 = b.c;
        List<String> r2 = r0.get(10);
        List<String> r1 = r0.get(9);
        if (r1 == null) goto L18;
        if (r2 == null) goto L20;
        ArrayList r4 = new ArrayList(r2);
        ArrayList r3 = new ArrayList(r1);
        Iterator<String> r9 = r7.keys();
    L11:
        if (r9.hasNext() == false) goto L13;
        String r5 = r9.next();
        r4.add(r5);
        r3.add(r5);
        ((ArrayList) b.g).add(r5);
        goto L11
    L13:
        HashMap<Integer, List<String>> r10 = b.c;
        r10.put(10, r4);
        r10.put(9, r3);
        b.f = false;
        return;
    L20:
        return;
    L18:
        return;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public void addLiveCoreInfoKey(JSONObject r4) {
        if (r4 != null) goto L4;
        IPerfToolsService r5 = b.a;
        return;
    L4:
        if (b.e == false) goto L16;
        List<String> r0 = b.c.get(10);
        if (r0 == null) goto L18;
        ArrayList r2 = new ArrayList(r0);
        Iterator<String> r6 = r4.keys();
    L10:
        if (r6.hasNext() == false) goto L12;
        r2.add(r6.next());
        goto L10
    L12:
        b.c.put(10, r2);
        b.e = false;
        return;
    L18:
        return;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public List<a> getDataForEntrance(int r1) {
        return b.f(r1);
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public List<Double> getDataForPerformanceEntrance(int r4) {
        String r5 = b.h(r4).get("data_performance_type");
        ArrayList r0 = new ArrayList();
        if (TextUtils.isEmpty(r5) == true) goto L13;
        HashMap<String, b.a> r1 = b.b;
        if (r1.containsKey(r5) == false) goto L13;
        b.a r6 = r1.get(r5);
        if (r6 == null) goto L13;
        if (r6.d != 2) goto L13;
        r0.addAll(r6.c);
    L13:
        return r0;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public String getNormalInfo(String r1) {
        return b.g(r1);
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public String getPerformanceChartTitle(int r2) {
        return b.h(r2).get("data_performance_title");
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public void initAndShowDebugTool(boolean r2) {
        if (this.mPresenter != null) goto L5;
        this.mPresenter = new i();
    L5:
        if (r2 == true) goto L8;
        dismiss();
        return;
    L8:
        i r3 = this.mPresenter;
        if (r3.h == false) goto L11;
        return;
    L11:
        if (r3.g == true) goto L16;
        r3.c();
        return;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public void removeClientInfo(JSONObject r5) {
        if (r5 == null) goto L17;
        final i r0 = this.mPresenter;
        if (r0 == null) goto L28;
        Iterator<String> r6 = r5.keys();
    L8:
        if (r6.hasNext() == false) goto L29;
        final String r1 = r6.next();
        if (r0.l == null) goto L8;
        if (c.a() == false) goto L13;
        DebugNormalInfoAdapter r2 = r0.l;
        a r3 = r2.A2(r1);
        if (r3 == null) goto L8;
        ((ArrayList) r2.b).remove(r3);
        r2.notifyDataSetChanged();
        goto L8
    L13:
        r0.A.post(new sr0.a(r0, r1));
        goto L8
    L29:
        return;
    L28:
        return;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public void removeSceneInfo(String r4) {
        IPerfToolsService r0 = b.a;
        if (TextUtils.isEmpty(r4) == true) goto L15;
        HashMap<String, b.a> r1 = b.b;
        if (r1.containsKey(r4) == false) goto L16;
        b.a r2 = r1.get(r4);
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2.d != 1) goto L18;
        r1.remove(r4);
        b.j(r4, false);
        return;
    L18:
        return;
    L16:
        return;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public IPerfToolsService setActivity(Activity r3) {
        i r0 = this.mPresenter;
        if (r0 != null) goto L5;
        return this;
    L5:
        r0.x = r3;
        if (r3 == null) goto L8;
        r0.a = (WindowManager) r3.getApplicationContext().getSystemService("window");
    L8:
        return this;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public void updateNormalInfo(final a r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r6.b) == true) goto L55;
        i r0 = this.mPresenter;
        if (r0 == null) goto L56;
        boolean r2 = false;
        if (r0.l == null) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == true) goto L13;
        return;
    L13:
        if (r0.d() == false) goto L61;
        String r3 = r6.a;
        IPerfToolsService r4 = b.a;
        if (TextUtils.isEmpty(r3) == true) goto L40;
        IPerfToolsService r5 = b.a;
        if (r5 == null) goto L40;
        int r7 = r5.getCurrentEntrance();
        if (r7 != 1) goto L27;
        if (b.i() == false) goto L25;
        r7 = 9;
    L29:
        List<String> r8 = b.c.get(Integer.valueOf(r7));
        if (r8 == null) goto L40;
        if (r8.isEmpty() == true) goto L40;
        Iterator<String> r9 = r8.iterator();
    L36:
        if (r9.hasNext() == false) goto L40;
        if (r9.next().equals(r3) == false) goto L36;
        r2 = true;
        goto L40
    L25:
        r7 = 10;
        goto L29
    L27:
        if (r7 != 2) goto L29;
        r2 = b.a(r3);
    L40:
        if (r2 == true) goto L42;
        return;
    L42:
        final i r10 = this.mPresenter;
        if (r10.l != null) goto L45;
        return;
    L45:
        if (r10.d() == true) goto L47;
        return;
    L47:
        if (c.a() == true) goto L49;
        r10.A.post(new sr0.c(r10, r6));
        return;
    L49:
        r10.l.y2(r6);
        return;
    L61:
        return;
    L10:
        r1 = false;
        goto L11
    L56:
        return;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public void updatePerformanceChart(double r4) {
        i r0 = this.mPresenter;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.m == null) goto L10;
        LineChartView.Data r1 = new LineChartView.Data(r4, new Date());
        LineChartView r5 = r0.m;
        ((ArrayList) r5.j).add(r1);
        r5.i();
        return;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public void addPerformanceData(String r11, double r12) {
        IPerfToolsService r0 = b.a;
        if (TextUtils.isEmpty(r11) == true) goto L89;
        IPerfToolsService r1 = b.a;
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.isContentVisible() == true) goto L10;
        return;
    L10:
        if (r1.isPerformanceViewVisible() == false) goto L12;
    L66:
        HashMap<String, b.a> r2 = b.b;
        if (r2.containsKey(r11) == true) goto L69;
        b.a r3 = new b.a();
        ArrayList r4 = new ArrayList();
        r3.c = r4;
        r4.add(Double.valueOf(r12));
        r3.d = 2;
    L79:
        r2.put(r11, r3);
        if (r1.isPerformanceViewVisible() == false) goto L92;
        String r5 = b.h(r1.getCurrentPerformanceType()).get("data_performance_type");
        if (r5 != null) goto L85;
    L87:
        r1.updatePerformanceChart(r12);
        return;
    L85:
        if (r5.equals(r11) == true) goto L87;
        return;
    L92:
        return;
    L69:
        r3 = r2.get(r11);
        if (r3 != null) goto L72;
    L78:
        r3 = new b.a();
        ArrayList r6 = new ArrayList();
        r3.c = r6;
        r6.add(Double.valueOf(r12));
        r3.d = 2;
        goto L79
    L72:
        if (r3.d != 2) goto L78;
        if (r3.c != null) goto L77;
        r3.c = new ArrayList();
    L77:
        ((ArrayList) r3.c).add(Double.valueOf(r12));
        goto L79
    L12:
        if (r1.isNormalViewVisible() == false) goto L66;
        if (TextUtils.isEmpty("gift_effect") == false) goto L16;
        boolean r7 = false;
    L17:
        if (r7 == false) goto L56;
        String r8 = b.e("gift_effect", r11);
        r11.getClass();
        byte r9 = -1;
        switch(r11.hashCode()) {
            case -1304311193: goto L34;
            case -947329893: goto L30;
            case -816061345: goto L26;
            case 1077775884: goto L22;
            default: goto L37;
        };
    L37:
        switch(r9) {
            case 0: goto L51;
            case 1: goto L47;
            case 2: goto L43;
            case 3: goto L39;
            default: goto L56;
        };
    L39:
        String r10 = s1.B(2131921252);
        StringBuilder r13 = new StringBuilder();
        double r14 = 100.0d * r12;
        r13.append(r14);
        r13.append("%");
        r1.updateNormalInfo(new a(r8, r10, r13.toString()));
        HashMap<String, b.a> r15 = b.b;
        b.a r16 = r15.get(r8);
        if (r16 != null) goto L42;
        r16 = new b.a();
        r16.d = 0;
    L42:
        r16.a = r14 + "%";
        r15.put(r8, r16);
        goto L56
    L43:
        r1.updateNormalInfo(new a(r8, s1.B(2131921245), r12 + s1.B(2131921248)));
        HashMap<String, b.a> r17 = b.b;
        b.a r18 = r17.get(r8);
        if (r18 != null) goto L46;
        r18 = new b.a();
        r18.d = 0;
    L46:
        r18.a = r12 + s1.B(2131921248);
        r17.put(r8, r18);
        goto L56
    L47:
        r1.updateNormalInfo(new a(r8, s1.B(2131921254), r12 + "s"));
        HashMap<String, b.a> r19 = b.b;
        b.a r20 = r19.get(r8);
        if (r20 != null) goto L50;
        r20 = new b.a();
        r20.d = 0;
    L50:
        r20.a = r12 + "s";
        r19.put(r8, r20);
        goto L56
    L51:
        r1.updateNormalInfo(new a(r8, s1.B(2131921268), r12 + ""));
        HashMap<String, b.a> r21 = b.b;
        b.a r22 = r21.get(r8);
        if (r22 != null) goto L54;
        r22 = new b.a();
        r22.d = 0;
    L54:
        r22.a = r12 + "";
        r21.put(r8, r22);
        goto L56
    L22:
        if (r11.equals("data_cpu_rate") == false) goto L37;
        r9 = 3;
        goto L37
    L26:
        if (r11.equals("data_temperature") == false) goto L37;
        r9 = 2;
        goto L37
    L30:
        if (r11.equals("data_cpu_speed") == false) goto L37;
        r9 = 1;
        goto L37
    L34:
        if (r11.equals("data_avg_fps") == false) goto L37;
        r9 = 0;
    L56:
        if (TextUtils.isEmpty("ktv") == false) goto L58;
        boolean r23 = false;
    L59:
        if (r23 == false) goto L66;
        String r24 = b.e("ktv", r11);
        if ("data_http_rtt".equals(r11) == false) goto L66;
        r1.updateNormalInfo(new a(r24, s1.B(2131921274), r12 + "ms"));
        HashMap<String, b.a> r25 = b.b;
        b.a r26 = r25.get(r24);
        if (r26 != null) goto L65;
        r26 = new b.a();
        r26.d = 0;
    L65:
        r26.a = r12 + "ms";
        r25.put(r24, r26);
        goto L66
    L58:
        r23 = ((ArrayList) b.d).contains(Integer.valueOf(b.d("ktv")));
        goto L59
    L16:
        r7 = ((ArrayList) b.d).contains(Integer.valueOf(b.d("gift_effect")));
        goto L17
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public void setData(String r5, String r6) {
        IPerfToolsService r0 = b.a;
        if (TextUtils.isEmpty(r5) == true) goto L30;
        if (r6 == null) goto L31;
        IPerfToolsService r1 = b.a;
        if (r1 == null) goto L35;
        String r7 = r6.trim();
        b.a r2 = new b.a();
        r2.a = r7;
        r2.d = 0;
        b.b.put(r5, r2);
        if (r1.isContentVisible() == false) goto L36;
        int r3 = r1.getCurrentEntrance();
        if (r3 == 1) goto L14;
    L17:
        List<String> r4 = b.c.get(Integer.valueOf(r3));
        if (r4 != null) goto L20;
        return;
    L20:
        if (r4.isEmpty() == false) goto L22;
        return;
    L22:
        if (r4.contains(r5) == true) goto L24;
        return;
    L24:
        if (r3 == 2) goto L26;
    L28:
        r1.updateNormalInfo(new a(r5, b.c(r5), r7));
        return;
    L26:
        if (b.a(r5) == true) goto L28;
        return;
    L14:
        if (b.i() == false) goto L16;
        r3 = 9;
        goto L17
    L16:
        r3 = 10;
        goto L17
    L36:
        return;
    L35:
        return;
    L31:
        return;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public void setDialog(Dialog r2, boolean r3) {
        i r0 = this.mPresenter;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.u = r2;
        r0.v = r3;
        if (r0.h == false) goto L9;
        r0.d.setDialog(r2);
        return;
    L9:
        if (r0.g == false) goto L13;
        r0.c.setDialog(r2);
        return;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public void setSceneInfo(String r6, Map<String, String> r7) {
        IPerfToolsService r0 = b.a;
        if (TextUtils.isEmpty(r6) == true) goto L28;
        if (r7 == null) goto L30;
        IPerfToolsService r1 = b.a;
        if (r1 == null) goto L32;
        b.a r2 = new b.a();
        HashMap<String, String> r3 = new HashMap();
        r2.b = r3;
        r3.putAll(r7);
        r2.d = 1;
        HashMap<String, b.a> r4 = b.b;
        r4.put(r6, r2);
        b.j(r6, true);
        if ("link_mic".equals(r6) == true) goto L11;
    L19:
        int r8 = b.d(r6);
        List<String> r9 = b.c.get(Integer.valueOf(r8));
        if (r9 != null) goto L22;
        return;
    L22:
        if (r9.isEmpty() == true) goto L33;
        Iterator<String> r10 = r9.iterator();
    L26:
        if (r10.hasNext() == false) goto L34;
        String r11 = r10.next();
        String r5 = b.g(r11);
        b.a.updateNormalInfo(new a(r11, b.c(r11), r5));
        goto L26
    L34:
        return;
    L33:
        return;
    L11:
        if (r7.containsKey("stream_mix_on_client") == false) goto L19;
        String r12 = r7.get("stream_mix_on_client");
        if (r12 != null) goto L15;
    L17:
        String r13 = "mixOnServer";
    L18:
        r1.updateNormalInfo(new a("data_mix_type", s1.B(2131921289), r13));
        b.a r14 = new b.a();
        r14.d = 0;
        r14.a = r13;
        r4.put("data_mix_type", r14);
        goto L19
    L15:
        if (r12.equals("1") == false) goto L17;
        r13 = "mixOnClient";
        goto L18
    L32:
        return;
    L30:
        return;
    }
}
