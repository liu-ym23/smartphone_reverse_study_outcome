package com.cronutils.b;

import com.cronutils.model.CompositeCron;
import com.cronutils.model.Cron;
import com.cronutils.model.SingleCron;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.definition.CronNicknames;
import com.cronutils.model.field.definition.FieldDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Integer, List<b>> f3400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CronDefinition f3401b;

    public a(CronDefinition r4) {
        this.f3400a = new HashMap();
        this.f3401b = (CronDefinition) ZeusTransformUtils.preCheckCast(com.cronutils.utils.a.a(r4, "CronDefinition must not be null"), CronDefinition.class, "com.obric.memorydata.plugin");
        a(r4);
    }

    private b a(FieldDefinition r3) {
        return new b(r3.getFieldName(), r3.getConstraints(), r3.isOptional());
    }

    private Cron a(String r2, Set<CronNicknames> r3, CronNicknames r4, Cron r5) {
        Set r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Cron r6 = (Cron) ZeusTransformUtils.wrapperContextForParams(r5, Cron.class, "com.obric.memorydata.plugin");
        if (r1.contains(r4) == false) goto L6;
        return r6;
    L6:
        throw new IllegalArgumentException(String.format("Nickname %s not supported!", new Object[]{r2}));
    }

    private void a(CronDefinition r5) {
        List<b> r6 = (List) ZeusTransformUtils.preCheckCast(r5.getFieldDefinitions().stream().map(new $$Lambda$a$Fs8zkfTbx2QIY2N41mNo1emGPI(this)).sorted(b.c()).collect(Collectors.toList()), List.class, "com.obric.memorydata.plugin");
        List<b> r0 = r6;
    L4:
        if (a(r0) == false) goto L6;
        int r1 = r0.size() - 1;
        ArrayList r2 = new ArrayList(r0.subList(0, r1));
        this.f3400a.put(Integer.valueOf(r1), r2);
        r0 = r2;
        goto L4
    L6:
        this.f3400a.put(Integer.valueOf(r6.size()), r6);
    }

    private boolean a(List<b> r3) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r2.isEmpty() == false) goto L5;
    L7:
        return false;
    L5:
        if (((b) ZeusTransformUtils.preCheckCast(r2.get(r2.size() - 1), b.class, "com.obric.memorydata.plugin")).b() == false) goto L7;
        return true;
    }

    private static /* synthetic */ boolean b(String r1) {
        return r1.endsWith(",");
    }

    private static /* synthetic */ int c(String r1) {
        return r1.split("\\|").length;
    }

    public static /* synthetic */ int lambda$0ZClY4Wv8wyMKw0uWZsK_czRx9c(String r0) {
        return c(r0);
    }

    /* JADX INFO: renamed from: lambda$Fs8zkfTbx2QIY2N-41mNo1emGPI, reason: not valid java name */
    public static /* synthetic */ b m117lambda$Fs8zkfTbx2QIY2N41mNo1emGPI(a r0, FieldDefinition r1) {
        return r0.a(r1);
    }

    public static /* synthetic */ boolean lambda$rCTlDNLVx68iUJZIvpu3FzNFnnc(String r0) {
        return b(r0);
    }

    public Cron a(String r18) {
        com.cronutils.utils.a.a(r18, "Expression must not be null");
        String r4 = r18.replaceAll("\\s+", " ").trim();
        if (com.cronutils.utils.c.a(r4) == true) goto L92;
        Set<CronNicknames> r5 = this.f3401b.getCronNicknames();
        int r8 = 1;
        int r9 = 0;
        if (r18.startsWith("@") == false) goto L58;
        if (r5.isEmpty() == true) goto L56;
        r18.hashCode();
        byte r6 = -1;
        switch(r18.hashCode()) {
            case -1353831664: goto L40;
            case -357645332: goto L36;
            case -245765455: goto L32;
            case 30722021: goto L28;
            case 173953217: goto L24;
            case 231099082: goto L20;
            case 1107347405: goto L16;
            case 1927611865: goto L12;
            default: goto L43;
        };
    L43:
        switch(r6) {
            case 0: goto L54;
            case 1: goto L53;
            case 2: goto L52;
            case 3: goto L51;
            case 4: goto L50;
            case 5: goto L49;
            case 6: goto L48;
            case 7: goto L45;
            default: goto L58;
        };
    L45:
        CronNicknames r2 = CronNicknames.DAILY;
        Cron r3 = com.cronutils.a.a.e(this.f3401b);
    L47:
        return a(r18, r5, r2, r3);
    L48:
        r2 = CronNicknames.MONTHLY;
        r3 = com.cronutils.a.a.c(this.f3401b);
        goto L47
    L49:
        r2 = CronNicknames.YEARLY;
        r3 = com.cronutils.a.a.a(this.f3401b);
        goto L47
    L50:
        r2 = CronNicknames.WEEKLY;
        r3 = com.cronutils.a.a.d(this.f3401b);
        goto L47
    L51:
        r2 = CronNicknames.REBOOT;
        r3 = com.cronutils.a.a.h(this.f3401b);
        goto L47
    L52:
        r2 = CronNicknames.HOURLY;
        r3 = com.cronutils.a.a.g(this.f3401b);
        goto L47
    L53:
        r2 = CronNicknames.ANNUALLY;
        r3 = com.cronutils.a.a.b(this.f3401b);
        goto L47
    L54:
        r2 = CronNicknames.MIDNIGHT;
        r3 = com.cronutils.a.a.f(this.f3401b);
        goto L47
    L12:
        if (r18.equals("@daily") == false) goto L43;
        r6 = 7;
        goto L43
    L16:
        if (r18.equals("@monthly") == false) goto L43;
        r6 = 6;
        goto L43
    L20:
        if (r18.equals("@yearly") == false) goto L43;
        r6 = 5;
        goto L43
    L24:
        if (r18.equals("@weekly") == false) goto L43;
        r6 = 4;
        goto L43
    L28:
        if (r18.equals("@reboot") == false) goto L43;
        r6 = 3;
        goto L43
    L32:
        if (r18.equals("@hourly") == false) goto L43;
        r6 = 2;
        goto L43
    L36:
        if (r18.equals("@annually") == false) goto L43;
        r6 = 1;
        goto L43
    L40:
        if (r18.equals("@midnight") == false) goto L43;
        r6 = 0;
        goto L43
    L56:
        throw new IllegalArgumentException("Nicknames not supported!");
    L58:
        if (r18.contains("||") == false) goto L62;
        return new CompositeCron((List) ZeusTransformUtils.preCheckCast(Arrays.stream(r18.split("\\|\\|")).map(new $$Lambda$OpEc5BZD2ZCTg5CCIjC_7dVNhCI(this)).collect(Collectors.toList()), List.class, "com.obric.memorydata.plugin"));
    L62:
        if (r18.contains("|") == false) goto L75;
        ArrayList r7 = new ArrayList();
        int r10 = Arrays.stream(r18.split("\\s+")).mapToInt($$Lambda$a$0ZClY4Wv8wyMKw0uWZsK_czRx9c.INSTANCE).max().orElse(0);
        int r11 = 0;
    L64:
        if (r11 >= r10) goto L74;
        StringBuilder r12 = new StringBuilder();
        String[] r13 = r18.split("\\s+");
        int r14 = r13.length;
        int r15 = r9;
    L66:
        if (r15 >= r14) goto L72;
        String r16 = r13[r15];
        if (r16.contains("|") == false) goto L70;
        Object[] r17 = new Object[r8];
        r17[0] = r16.split("\\|")[r11];
        String r19 = String.format("%s ", r17);
    L71:
        r12.append(r19);
        r15 = r15 + 1;
        r8 = 1;
        goto L66
    L70:
        Object[] r110 = new Object[r8];
        r110[0] = r16;
        r19 = String.format("%s ", r110);
        goto L71
    L72:
        r7.add(r12.toString().trim());
        r11 = r11 + 1;
        r8 = 1;
        r9 = 0;
        goto L64
    L74:
        return new CompositeCron((List) ZeusTransformUtils.preCheckCast(r7.stream().map(new $$Lambda$OpEc5BZD2ZCTg5CCIjC_7dVNhCI(this)).collect(Collectors.toList()), List.class, "com.obric.memorydata.plugin"));
    L75:
        String[] r1 = r4.toUpperCase().split(" ");
        int r20 = r1.length;
        String r21 = (String) ZeusTransformUtils.preCheckCast(Arrays.stream(r1).filter($$Lambda$a$rCTlDNLVx68iUJZIvpu3FzNFnnc.INSTANCE).findAny().orElse(null), String.class, "com.obric.memorydata.plugin");
        if (r21 != null) goto L90;
        List r22 = (List) ZeusTransformUtils.preCheckCast(this.f3400a.get(Integer.valueOf(r20)), List.class, "com.obric.memorydata.plugin");
        if (r22 == null) goto L88;
        int r23 = r1.length;     // Catch: IllegalArgumentException -> L84
        ArrayList r24 = new ArrayList(r23 + 1);     // Catch: IllegalArgumentException -> L84
        int r25 = 0;
    L80:
        if (r25 >= r23) goto L82;
        r24.add(((b) ZeusTransformUtils.preCheckCast(r22.get(r25), b.class, "com.obric.memorydata.plugin")).a(r1[r25]));     // Catch: IllegalArgumentException -> L84
        r25 = r25 + 1;     // Catch: IllegalArgumentException -> L84
        goto L80
    L82:
        return new SingleCron(this.f3401b, r24).validate();
    L84:
        e = move-exception;
        throw new IllegalArgumentException(String.format("Failed to parse cron expression. %s", new Object[]{e.getMessage()}), e);
    L88:
        throw new IllegalArgumentException(String.format("Cron expression contains %s parts but we expect one of %s", new Object[]{Integer.valueOf(r20), this.f3400a.keySet()}));
    L90:
        throw new IllegalArgumentException(String.format("Invalid field value! Trailing commas not permitted! '%s'", new Object[]{r21}));
    L92:
        throw new IllegalArgumentException("Empty expression!");
    }
}
