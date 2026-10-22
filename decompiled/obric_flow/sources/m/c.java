package m;

import ai.j0;
import androidx.room.writer.DaoWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final HashMap f19861i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f19864c;
    public final Date d;
    public boolean e;
    public final m.b f;
    public final i4.a g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i4.a f19865h;

    class a extends HashMap<String, String> {
        public a() {
            put("酒店名称", "hotelNew");
        }
    }

    class b extends HashMap<String, String> {
        public b() {
            put("入住人姓名", "bookPerson");
            put("入住日期", "dateStart");
            put("退房日期", "dateEnd");
            put("酒店名称", "hotel");
            put("房间类型", "roomType");
        }
    }

    /* JADX INFO: renamed from: m.c$c, reason: collision with other inner class name */
    class C0032c extends HashMap<String, String> {
        public C0032c() {
            put("订单编号", "orderNumber");
        }
    }

    class d extends HashMap<String, String> {
        public d() {
            put("乘机人姓名", "bookPerson");
            put("出发时间", "dateStart");
            put("到达时间", "dateEnd");
            put("出发地", "fromPos");
            put("到达地", "toPos");
            put("航班号", "travelNumber");
        }
    }

    class e extends HashMap<String, String> {
        public e() {
            put("乘机人姓名", "bookPerson");
            put("原出发时间", "dateStartOld");
            put("原到达时间", "dateEndOld");
            put("原出发地", "fromPosOld");
            put("原到达地", "toPosOld");
            put("原航班号", "travelNumberOld");
            put("现出发时间", "dateStartNew");
            put("现到达时间", "dateEndNew");
            put("现出发地", "fromPosNew");
            put("现到达地", "toPosNew");
            put("现航班号", "travelNumberNew");
        }
    }

    class f extends HashMap<String, String> {
        public f() {
            put("乘机人姓名", "bookPerson");
            put("出发时间", "dateStart");
            put("到达时间", "dateEnd");
            put("出发地", "fromPos");
            put("到达地", "toPos");
            put("航班号", "travelNumber");
        }
    }

    class g extends HashMap<String, String> {
        public g() {
            put("乘车人姓名", "bookPerson");
            put("出发时间", "dateStart");
            put("到达时间", "dateEnd");
            put("出发站", "fromPos");
            put("到达站", "toPos");
            put("车次", "travelNumber");
            put("车厢号", "trainCarriageNumber");
            put("座位号", "trainSeatNumber");
            put("检票口", "ticketCheck");
        }
    }

    class h extends HashMap<String, String> {
        public h() {
            put("乘车人姓名", "bookPerson");
            put("原出发时间", "dateStartOld");
            put("原到达时间", "dateEndOld");
            put("原出发站", "fromPosOld");
            put("原到达站", "toPosOld");
            put("原车次", "travelNumberOld");
            put("原车厢号", "trainCarriageNumberOld");
            put("原座位号", "trainSeatNumberOld");
            put("原检票口", "ticketCheckOld");
            put("现出发时间", "dateStartNew");
            put("现到达时间", "dateEndNew");
            put("现出发站", "fromPosNew");
            put("现到达站", "toPosNew");
            put("现车次", "travelNumberNew");
            put("现车厢号", "trainCarriageNumberNew");
            put("现座位号", "trainSeatNumberNew");
            put("现检票口", "ticketCheckNew");
        }
    }

    class i extends HashMap<String, String> {
        public i() {
            put("乘车人姓名", "bookPerson");
            put("出发时间", "dateStart");
            put("到达时间", "dateEnd");
            put("出发站", "fromPos");
            put("到达站", "toPos");
            put("车次", "travelNumber");
            put("车厢号", "trainCarriageNumber");
            put("座位号", "trainSeatNumber");
            put("检票口", "ticketCheck");
        }
    }

    class j extends HashMap<String, String> {
        public j() {
            put("入住人姓名", "bookPerson");
            put("入住日期", "dateStart");
            put("退房日期", "dateEnd");
            put("酒店名称", "hotel");
            put("房间类型", "roomType");
        }
    }

    class k extends HashMap<String, String> {
        public k() {
            put("入住人姓名", "bookPerson");
            put("原入住日期", "dateStartOld");
            put("原退房日期", "dateEndOld");
            put("原酒店名称", "hotelOld");
            put("原房间类型", "roomTypeOld");
            put("现入住日期", "dateStartNew");
            put("现退房日期", "dateEndNew");
            put("现酒店名称", "hotelNew");
            put("现房间类型", "roomTypeNew");
        }
    }

    class l extends HashMap<String, String> {
        public l() {
            put("酒店名称", "hotelOld");
        }
    }

    static {
        HashMap r5 = new HashMap();
        f19861i = r5;
        r5.put(0, ChronoField.YEAR);
        r5.put(1, ChronoField.MONTH_OF_YEAR);
        r5.put(2, ChronoField.DAY_OF_MONTH);
        r5.put(3, ChronoField.HOUR_OF_DAY);
        r5.put(4, ChronoField.MINUTE_OF_HOUR);
        r5.put(5, ChronoField.SECOND_OF_MINUTE);
        r5.put(10, ChronoUnit.YEARS);
        r5.put(11, ChronoUnit.MONTHS);
        r5.put(12, ChronoUnit.DAYS);
        r5.put(13, ChronoUnit.HOURS);
        r5.put(14, ChronoUnit.MINUTES);
        r5.put(15, ChronoUnit.SECONDS);
    }

    /* JADX WARN: Type inference failed for: r2v12, types: [java.time.ZonedDateTime] */
    /* JADX WARN: Type inference failed for: r9v61, types: [java.time.ZonedDateTime] */
    public c(String r34, m.b r35, i4.a r36) {
        this.f19863b = "";
        this.f19864c = "";
        this.e = true;
        i4.a r10 = new i4.a(12);
        this.g = r10;
        this.f19862a = r34;
        this.f = r35;
        this.f19865h = r36;
        Matcher r5 = A.d.b().matcher(r34);
        Matcher r11 = A.e.b().matcher(r34);
        LocalDateTime r14 = null;
        if (r5.find() == false) goto L5;
    L421:
        r14 = t.c(r34);     // Catch: Exception -> L9
        int[] r12 = (int[]) r10.f17502b;     // Catch: Exception -> L9
        r12[0] = r14.getYear();     // Catch: Exception -> L9
        r12[1] = r14.getMonthValue();     // Catch: Exception -> L9
        r12[2] = r14.getDayOfMonth();     // Catch: Exception -> L9
        if (r14.getHour() < 0) goto L12;
        r12[3] = r14.getHour();     // Catch: Exception -> L9
    L12:
        if (r14.getMinute() <= 0) goto L15;
        r12[4] = r14.getMinute();     // Catch: Exception -> L9
    L15:
        if (r14.getSecond() <= 0) goto L19;
        r12[5] = r14.getSecond();     // Catch: Exception -> L9
    L19:
        i4.a r13 = this.f19865h;
        if (r14 != null) goto L382;
        Matcher r15 = A.f.b().matcher(r34);
        if (r15.find() == false) goto L29;
        ((int[]) r10.f17502b)[0] = Integer.parseInt(r15.group());
        int[] r16 = (int[]) r10.f17502b;
        int r17 = r16[0];
        if (r17 < 0) goto L29;
        if (r17 >= 100) goto L29;
        if (r17 >= 30) goto L28;
        r16[0] = r17 + 2000;
        goto L29
    L28:
        r16[0] = r17 + 1900;
    L29:
        Matcher r18 = A.g.b().matcher(r34);
        if (r18.find() == false) goto L32;
        ((int[]) r10.f17502b)[0] = Integer.parseInt(r18.group());
    L32:
        Matcher r19 = A.f19798h.b().matcher(r34);
        if (r19.find() == false) goto L35;
        ((int[]) r10.f17502b)[1] = Integer.parseInt(r19.group());
        b(1);
    L35:
        Matcher r110 = A.f19800i.b().matcher(r34);
        if (r110.find() == false) goto L38;
        ((int[]) r10.f17502b)[2] = Integer.parseInt(r110.group());
        b(2);
    L38:
        Matcher r111 = A.f19801j.b().matcher(r34);
        if (r111.find() == false) goto L43;
        String r112 = r111.group();
        Matcher r113 = Pattern.compile("(月|\\.|\\-)").matcher(r112);
        if (r113.find() == false) goto L43;
        int r114 = r113.start();
        String r115 = r112.substring(0, r114);
        String r116 = r112.substring(r114 + 1);
        ((int[]) r10.f17502b)[1] = Integer.parseInt(r115);
        ((int[]) r10.f17502b)[2] = Integer.parseInt(r116);
        b(1);
    L43:
        String[] r117 = ((String) r13.f17503c).split(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        int[] r118 = new int[6];
        int r20 = 0;
    L44:
        if (r20 >= 6) goto L46;
        r118[r20] = Integer.parseInt(r117[r20]);
        r20 = r20 + 1;
        goto L44
    L46:
        LocalDateTime r21 = LocalDateTime.of(r118[0], r118[1], r118[2], r118[3], r118[4], r118[5]);
        Matcher r119 = A.f19805l.b().matcher(r34);
        if (r119.find() == false) goto L49;
        r21 = r21.minusDays(Integer.parseInt(r119.group()));
        boolean r120 = true;
    L50:
        Matcher r121 = A.f19806m.b().matcher(r34);
        if (r121.find() == false) goto L53;
        r21 = r21.plusDays(Integer.parseInt(r121.group()));
        r120 = true;
    L53:
        Matcher r122 = A.f19808n.b().matcher(r34);
        if (r122.find() == false) goto L56;
        r21 = r21.minusMonths(Integer.parseInt(r122.group()));
        r120 = true;
    L56:
        Matcher r123 = A.f19810o.b().matcher(r34);
        if (r123.find() == false) goto L59;
        r21 = r21.plusMonths(Integer.parseInt(r123.group()));
        r120 = true;
    L59:
        Matcher r124 = A.f19812p.b().matcher(r34);
        if (r124.find() == false) goto L62;
        r21 = r21.minusYears(Integer.parseInt(r124.group()));
        r120 = true;
    L62:
        Matcher r125 = A.f19814q.b().matcher(r34);
        if (r125.find() == false) goto L65;
        r21 = r21.plusYears(Integer.parseInt(r125.group()));
        r120 = true;
    L65:
        if (r120 == false) goto L67;
        a(r21);
    L67:
        String[] r22 = ((String) r13.f17503c).split(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        int[] r126 = new int[6];
        int r127 = 0;
    L68:
        if (r127 >= 6) goto L70;
        r126[r127] = Integer.parseInt(r22[r127]);
        r127 = r127 + 1;
        goto L68
    L70:
        LocalDateTime r23 = LocalDateTime.of(r126[0], r126[1], r126[2], r126[3], r126[4], r126[5]);
        Matcher r128 = A.f19816r.b().matcher(r34);
        if (r128.find() == false) goto L73;
        r23 = r23.minusHours(Integer.parseInt(r128.group()));
        boolean r129 = true;
    L74:
        Matcher r130 = A.s.b().matcher(r34);
        if (r130.find() == false) goto L78;
        r23 = r23.plusHours(Integer.parseInt(r130.group()));
        r129 = true;
    L78:
        if (kotlin.collections.a.p(A.f19819t, r34) == false) goto L81;
        r23 = r23.minusMinutes(30);
        r129 = true;
    L81:
        if (kotlin.collections.a.p(A.f19821u, r34) == false) goto L83;
        r23 = r23.plusMinutes(30);
        r129 = true;
    L83:
        Matcher r24 = A.f19825w.b().matcher(r34);
        if (r24.find() == false) goto L86;
        r23 = r23.minusMinutes(Integer.parseInt(r24.group()));
        boolean r25 = true;
        r129 = true;
    L87:
        Matcher r131 = A.f19827x.b().matcher(r34);
        if (r131.find() == false) goto L90;
        r23 = r23.plusMinutes(Integer.parseInt(r131.group()));
        boolean r132 = true;
        r129 = true;
    L91:
        if (r25 == false) goto L95;
        Matcher r26 = A.f19823v.b().matcher(r34);
        if (r26.find() == false) goto L95;
        r23 = r23.minusHours(Integer.parseInt(r26.group()));
        r129 = true;
    L95:
        if (r132 == false) goto L99;
        Matcher r27 = A.f19823v.b().matcher(r34);
        if (r27.find() == false) goto L99;
        r23 = r23.plusHours(Integer.parseInt(r27.group()));
        r129 = true;
    L99:
        Matcher r28 = A.f19831z.b().matcher(r34);
        if (r28.find() == false) goto L102;
        r23 = r23.minusSeconds(Integer.parseInt(r28.group()));
        boolean r29 = true;
        r129 = true;
    L103:
        Matcher r133 = A.A.b().matcher(r34);
        if (r133.find() == false) goto L106;
        r23 = r23.plusSeconds(Integer.parseInt(r133.group()));
        boolean r134 = true;
        r129 = true;
    L107:
        if (r29 == false) goto L114;
        Matcher r30 = A.f19823v.b().matcher(r34);
        if (r30.find() == false) goto L111;
        r23 = r23.minusHours(Integer.parseInt(r30.group()));
        r129 = true;
    L111:
        Matcher r31 = A.f19829y.b().matcher(r34);
        if (r31.find() == false) goto L114;
        r23 = r23.minusMinutes(Integer.parseInt(r31.group()));
        r129 = true;
    L114:
        if (r134 == false) goto L121;
        Matcher r32 = A.f19823v.b().matcher(r34);
        if (r32.find() == false) goto L118;
        r23 = r23.plusHours(Integer.parseInt(r32.group()));
        r129 = true;
    L118:
        Matcher r33 = A.f19829y.b().matcher(r34);
        if (r33.find() == false) goto L121;
        r23 = r23.plusMinutes(Integer.parseInt(r33.group()));
        r129 = true;
    L121:
        if (r129 == false) goto L123;
        a(r23);
    L123:
        String[] r37 = ((String) r13.d).split(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        int[] r38 = new int[6];
        int r135 = 0;
    L124:
        if (r135 >= 6) goto L126;
        r38[r135] = Integer.parseInt(r37[r135]);
        r135 = r135 + 1;
        goto L124
    L126:
        LocalDateTime r39 = LocalDateTime.of(r38[0], r38[1], r38[2], r38[3], r38[4], r38[5]);
        boolean[] r136 = {false, false, false};
        if (kotlin.collections.a.p(A.B, r34) == false) goto L130;
        r136[0] = true;
        r39 = r39.minusYears(2);
    L130:
        if (kotlin.collections.a.p(A.C, r34) == false) goto L133;
        r136[0] = true;
        r39 = r39.minusYears(1);
    L133:
        if (kotlin.collections.a.p(A.D, r34) == false) goto L136;
        r136[0] = true;
        r39 = r39.plusYears(0);
    L136:
        if (kotlin.collections.a.p(A.E, r34) == false) goto L139;
        r136[0] = true;
        r39 = r39.plusYears(1);
    L139:
        if (kotlin.collections.a.p(A.F, r34) == false) goto L142;
        r136[0] = true;
        r39 = r39.plusYears(2);
    L142:
        if (kotlin.collections.a.p(A.G, r34) == false) goto L145;
        r136[1] = true;
        r39 = r39.minusMonths(1);
    L145:
        if (kotlin.collections.a.p(A.H, r34) == false) goto L148;
        r136[1] = true;
        r39 = r39.plusMonths(0);
    L148:
        if (kotlin.collections.a.p(A.I, r34) == false) goto L151;
        r136[1] = true;
        r39 = r39.plusMonths(1);
    L151:
        if (kotlin.collections.a.p(A.J, r34) == false) goto L153;
        char r40 = 2;
        r136[2] = true;
        r39 = r39.minusDays(3);
    L155:
        if (kotlin.collections.a.p(A.K, r34) == false) goto L158;
        r136[r40] = true;
        r39 = r39.minusDays(2);
    L158:
        if (kotlin.collections.a.p(A.L, r34) == false) goto L161;
        r136[r40] = true;
        r39 = r39.minusDays(1);
    L161:
        if (kotlin.collections.a.p(A.M, r34) == false) goto L164;
        r136[r40] = true;
        r39 = r39.plusDays(0);
    L164:
        if (kotlin.collections.a.p(A.N, r34) == false) goto L167;
        r136[r40] = true;
        r39 = r39.plusDays(1);
    L167:
        if (kotlin.collections.a.p(A.O, r34) == false) goto L170;
        r136[r40] = true;
        r39 = r39.plusDays(2);
    L170:
        if (kotlin.collections.a.p(A.P, r34) == false) goto L172;
        r136[r40] = true;
        r39 = r39.plusDays(3);
    L172:
        Matcher r137 = A.Q.b().matcher(r34);
        if (r137.find() == false) goto L179;
        r136[r40] = true;
        int r41 = Integer.parseInt(r137.group());     // Catch: NumberFormatException -> L177
    L178:
        r39 = com.lynx.tasm.base.h.c(r39.minusWeeks(2), r41);
    L177:
        r41 = 1;
    L179:
        Matcher r42 = A.R.b().matcher(r34);
        if (r42.find() == false) goto L186;
        r136[2] = true;
        int r43 = Integer.parseInt(r42.group());     // Catch: NumberFormatException -> L184
    L185:
        r39 = com.lynx.tasm.base.h.c(r39.minusWeeks(1), r43);
    L184:
        r43 = 1;
    L186:
        Matcher r44 = A.T.b().matcher(r34);
        if (r44.find() == false) goto L193;
        r136[2] = true;
        int r45 = Integer.parseInt(r44.group());     // Catch: NumberFormatException -> L191
    L192:
        r39 = com.lynx.tasm.base.h.c(r39.plusWeeks(1), r45);
    L191:
        r45 = 1;
    L193:
        Matcher r46 = A.U.b().matcher(r34);
        if (r46.find() == false) goto L200;
        r136[2] = true;
        int r47 = Integer.parseInt(r46.group());     // Catch: NumberFormatException -> L198
    L199:
        r39 = com.lynx.tasm.base.h.c(r39.plusWeeks(2), r47);
    L198:
        r47 = 1;
    L200:
        Matcher r48 = A.S.b().matcher(r34);
        if (r48.find() == false) goto L220;
        r136[2] = true;
        int r49 = Integer.parseInt(r48.group());     // Catch: NumberFormatException -> L205
    L206:
        r39 = com.lynx.tasm.base.h.c(r39.plusWeeks(0), r49);
        this.f.getClass();
        int r138 = 0;
    L208:
        if (r138 >= 2) goto L213;
        if (((int[]) r10.f17502b)[r138] != (-1)) goto L220;
        r138 = r138 + 1;
        goto L208
    L213:
        LocalDateTime r139 = LocalDateTime.now();
        String r140 = (String) r13.f17503c;
        if (r140 == null) goto L217;
        String[] r141 = r140.split(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        r139 = LocalDateTime.of(Integer.valueOf(r141[0]).intValue(), Integer.valueOf(r141[1]).intValue(), Integer.valueOf(r141[2]).intValue(), Integer.valueOf(r141[3]).intValue(), Integer.valueOf(r141[4]).intValue(), Integer.valueOf(r141[5]).intValue());
    L217:
        if (r139.get(ChronoField.DAY_OF_WEEK) < r49) goto L220;
        r39 = r39.plusWeeks(1);
    L205:
        r49 = 1;
    L220:
        ZoneId r50 = t.f19909a;
        Objects.requireNonNull(r39, "localDateTime");
        DateTimeFormatter r51 = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss").withZone(t.f19909a);
        Objects.requireNonNull(r51, "formatter");
        String[] r52 = r39.atZone(ZoneId.systemDefault()).format(r51).split(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        if (r136[0] == false) goto L223;
    L226:
        ((int[]) r10.f17502b)[0] = Integer.parseInt(r52[0]);
    L228:
        if (r136[1] == false) goto L230;
    L233:
        ((int[]) r10.f17502b)[1] = Integer.parseInt(r52[1]);
    L235:
        if (r136[2] == false) goto L237;
        ((int[]) r10.f17502b)[2] = Integer.parseInt(r52[2]);
    L237:
        Matcher r53 = A.V.b().matcher(r34);
        if (r53.find() == false) goto L240;
        int r142 = 3;
        ((int[]) r10.f17502b)[3] = Integer.parseInt(r53.group());
        b(3);
    L242:
        if (kotlin.collections.a.p(A.W, r34) == false) goto L248;
        int[] r54 = (int[]) r10.f17502b;
        if (r54[r142] != (-1)) goto L246;
        r54[r142] = v.f19932b.b();
    L246:
        b(r142);
    L248:
        if (kotlin.collections.a.p(A.X, r34) == false) goto L254;
        int[] r55 = (int[]) r10.f17502b;
        if (r55[r142] != (-1)) goto L252;
        r55[r142] = v.f19933c.b();
    L252:
        b(r142);
    L254:
        if (kotlin.collections.a.p(A.Y, r34) == false) goto L259;
        int[] r56 = (int[]) r10.f17502b;
        if (r56[r142] != (-1)) goto L258;
        r56[r142] = v.d.b();
    L258:
        b(r142);
    L259:
        A r57 = A.Z;
        if (kotlin.collections.a.p(r57, r34) == false) goto L270;
        int[] r58 = (int[]) r10.f17502b;
        int r143 = r58[r142];
        if (r143 < 0) goto L267;
        if (r143 > 10) goto L267;
        r58[r142] = r143 + 12;
    L267:
        if (r58[r142] != (-1)) goto L269;
        r58[r142] = v.e.b();
    L269:
        b(r142);
    L270:
        A r59 = A.f19792a0;
        if (kotlin.collections.a.p(r59, r34) == false) goto L281;
        int[] r144 = (int[]) r10.f17502b;
        int r145 = r144[r142];
        if (r145 < 0) goto L277;
        if (r145 > 11) goto L277;
        r144[r142] = r145 + 12;
    L277:
        if (r144[r142] != (-1)) goto L279;
        r144[r142] = v.f.b();
    L279:
        b(r142);
    L281:
        if (kotlin.collections.a.p(A.f19793b0, r34) == false) goto L294;
        int[] r146 = (int[]) r10.f17502b;
        int r147 = r146[r142];
        if (r147 < 1) goto L287;
        if (r147 > 11) goto L287;
        r146[r142] = r147 + 12;
    L292:
        b(r142);
    L287:
        if (r147 != 12) goto L290;
        r146[r142] = 0;
        goto L292
    L290:
        if (r147 != (-1)) goto L292;
        r146[r142] = v.g.b();
    L294:
        if (kotlin.collections.a.p(A.f19795d0, r34) == true) goto L312;
        Matcher r148 = A.f19794c0.b().matcher(r34);
        if (r148.find() == true) goto L299;
    L301:
        int r149 = 4;
    L303:
        if (kotlin.collections.a.p(A.f19796e0, r34) == false) goto L306;
        ((int[]) r10.f17502b)[r149] = 15;
        b(r149);
    L306:
        if (kotlin.collections.a.p(A.f19797f0, r34) == false) goto L309;
        ((int[]) r10.f17502b)[r149] = 30;
        b(r149);
    L309:
        if (kotlin.collections.a.p(A.g0, r34) == false) goto L312;
        ((int[]) r10.f17502b)[r149] = 45;
        b(r149);
        goto L312
    L299:
        if (r148.group().equals("") == true) goto L301;
        r149 = 4;
        ((int[]) r10.f17502b)[4] = Integer.parseInt(r148.group());
        b(4);
    L312:
        if (kotlin.collections.a.p(A.f19799h0, r34) == true) goto L317;
        Matcher r60 = A.i0.b().matcher(r34);
        if (r60.find() == false) goto L317;
        ((int[]) r10.f17502b)[5] = Integer.parseInt(r60.group());
    L317:
        Pattern r61 = A.f19802j0.b();
        String r150 = this.f19862a;
        Matcher r62 = r61.matcher(r150);
        boolean r151 = r62.find();
        i4.a r152 = this.g;
        if (r151 == false) goto L320;
        String[] r63 = r62.group().split(":");
        ((int[]) r152.f17502b)[3] = Integer.parseInt(r63[0]);
        ((int[]) r152.f17502b)[4] = Integer.parseInt(r63[1]);
        ((int[]) r152.f17502b)[5] = Integer.parseInt(r63[2]);
        b(3);
        int r153 = 3;
    L325:
        if (kotlin.collections.a.p(r57, r150) == false) goto L336;
        int[] r64 = (int[]) r152.f17502b;
        int r65 = r64[r153];
        if (r65 < 0) goto L332;
        if (r65 > 10) goto L332;
        r64[r153] = r65 + 12;
    L332:
        if (r64[r153] != (-1)) goto L334;
        r64[r153] = v.e.b();
    L334:
        b(r153);
    L336:
        if (kotlin.collections.a.p(r59, r150) == false) goto L347;
        int[] r66 = (int[]) r152.f17502b;
        int r67 = r66[r153];
        if (r67 < 0) goto L343;
        if (r67 > 11) goto L343;
        r66[r153] = r67 + 12;
    L343:
        if (r66[r153] != (-1)) goto L345;
        r66[r153] = v.f.b();
    L345:
        b(r153);
    L347:
        if (kotlin.collections.a.p(A.l0, r150) == false) goto L360;
        int[] r68 = (int[]) r152.f17502b;
        int r69 = r68[r153];
        if (r69 < 1) goto L354;
        if (r69 > 11) goto L354;
        r68[r153] = r69 + 12;
    L357:
        if (r68[r153] != (-1)) goto L359;
        r68[r153] = v.g.b();
    L359:
        b(r153);
    L354:
        if (r69 != 12) goto L357;
        r68[r153] = 0;
    L360:
        Matcher r70 = A.f19807m0.b().matcher(r150);
        if (r70.find() == false) goto L363;
        String[] r71 = r70.group().split(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        ((int[]) r152.f17502b)[0] = Integer.parseInt(r71[0]);
        ((int[]) r152.f17502b)[1] = Integer.parseInt(r71[1]);
        ((int[]) r152.f17502b)[2] = Integer.parseInt(r71[2]);
    L363:
        Matcher r72 = A.f19809n0.b().matcher(r150);
        if (r72.find() == false) goto L366;
        String[] r73 = r72.group().split("/");
        ((int[]) r152.f17502b)[1] = Integer.parseInt(r73[0]);
        ((int[]) r152.f17502b)[2] = Integer.parseInt(r73[1]);
        ((int[]) r152.f17502b)[0] = Integer.parseInt(r73[2]);
    L366:
        Matcher r74 = A.f19811o0.b().matcher(r150);
        if (r74.find() == false) goto L369;
        String[] r75 = r74.group().split("\\.");
        ((int[]) r152.f17502b)[0] = Integer.parseInt(r75[0]);
        ((int[]) r152.f17502b)[1] = Integer.parseInt(r75[1]);
        ((int[]) r152.f17502b)[2] = Integer.parseInt(r75[2]);
    L369:
        String[] r76 = ((String) r13.f17503c).split(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        if (((int[]) r10.f17502b)[0] == (-1)) goto L372;
        String r77 = "" + Integer.toString(((int[]) r10.f17502b)[0]);
    L373:
        int r78 = 1;
    L375:
        if (r78 >= 6) goto L381;
        String r79 = j0.j(r77, DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        if (((int[]) r10.f17502b)[r78] == (-1)) goto L379;
        StringBuilder r80 = j0.u(r79);
        r80.append(Integer.toString(((int[]) r10.f17502b)[r78]));
        r77 = r80.toString();
    L380:
        r78 = r78 + 1;
        goto L375
    L379:
        StringBuilder r81 = j0.u(r79);
        r81.append(r76[r78]);
        r77 = r81.toString();
        goto L380
    L381:
        r13.f17503c = r77;
        r14 = LocalDateTime.of(1970, 1, 1, 0, 0);
        goto L382
    L372:
        r77 = "" + r76[0];
        goto L373
    L320:
        Matcher r82 = A.f19804k0.b().matcher(r150);
        if (r82.find() == false) goto L323;
        String[] r83 = r82.group().split(":");
        r153 = 3;
        ((int[]) r152.f17502b)[3] = Integer.parseInt(r83[0]);
        ((int[]) r152.f17502b)[4] = Integer.parseInt(r83[1]);
        b(3);
        goto L325
    L323:
        r153 = 3;
        goto L325
    L240:
        r142 = 3;
        goto L242
    L230:
        if (r136[2] == false) goto L235;
    L223:
        if (r136[1] == true) goto L226;
        if (r136[2] == false) goto L228;
    L153:
        r40 = 2;
        goto L155
    L106:
        r134 = false;
        goto L107
    L102:
        r29 = false;
        goto L103
    L90:
        r132 = false;
        goto L91
    L86:
        r25 = false;
        goto L87
    L73:
        r129 = false;
        goto L74
    L49:
        r120 = false;
    L382:
        String[] r84 = ((String) r13.f17503c).split(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        int r85 = 5;
    L383:
        if (r85 < 0) goto L387;
        if (((int[]) r10.f17502b)[r85] >= 0) goto L387;
        r85 = r85 - 1;
    L387:
        int r86 = 0;
    L388:
        if (r86 >= r85) goto L393;
        int[] r87 = (int[]) r10.f17502b;
        if (r87[r86] >= 0) goto L392;
        r87[r86] = Integer.parseInt(r84[r86]);
    L392:
        r86 = r86 + 1;
        goto L388
    L393:
        String[] r88 = new String[6];
        r88[0] = String.valueOf(((int[]) r10.f17502b)[0]);
        int r89 = ((int[]) r10.f17502b)[0];
        if (r89 >= 10) goto L396;
    L398:
        int r90 = ((int[]) r10.f17502b)[0];
        if (r90 > 0) goto L401;
    L403:
        int r91 = 1;
    L404:
        if (r91 >= 6) goto L407;
        r88[r91] = String.valueOf(((int[]) r10.f17502b)[r91]);
        r91 = r91 + 1;
        goto L404
    L407:
        if (Integer.parseInt(r88[0]) == (-1)) goto L419;
        StringBuilder r92 = new StringBuilder();
        r92.append(this.f19863b);
        this.f19863b = j0.q(r92, r88[0], "年");
        r14 = r14.withYear(Integer.valueOf(r88[0]).intValue());
        if (Integer.parseInt(r88[1]) == (-1)) goto L419;
        StringBuilder r93 = new StringBuilder();
        r93.append(this.f19863b);
        this.f19863b = j0.q(r93, r88[1], "月");
        r14 = r14.withMonth(Integer.valueOf(r88[1]).intValue());
        if (Integer.parseInt(r88[2]) == (-1)) goto L419;
        StringBuilder r94 = new StringBuilder();
        r94.append(this.f19863b);
        this.f19863b = j0.q(r94, r88[2], "日");
        r14 = r14.withDayOfMonth(Integer.valueOf(r88[2]).intValue());
        if (Integer.parseInt(r88[3]) == (-1)) goto L419;
        StringBuilder r95 = new StringBuilder();
        r95.append(this.f19863b);
        this.f19863b = j0.q(r95, r88[3], "时");
        r14 = r14.withHour(Integer.valueOf(r88[3]).intValue());
        if (Integer.parseInt(r88[4]) == (-1)) goto L419;
        StringBuilder r96 = new StringBuilder();
        r96.append(this.f19863b);
        this.f19863b = j0.q(r96, r88[4], "分");
        r14 = r14.withMinute(Integer.valueOf(r88[4]).intValue());
        if (Integer.parseInt(r88[5]) == (-1)) goto L419;
        StringBuilder r97 = new StringBuilder();
        r97.append(this.f19863b);
        this.f19863b = j0.q(r97, r88[5], "秒");
        r14 = r14.withSecond(Integer.valueOf(r88[5]).intValue());
    L419:
        r13.f17502b = (int[]) ((int[]) r10.f17502b).clone();
        r10.f17503c = (String) r13.f17503c;
        r10.d = (String) r13.d;
        Objects.requireNonNull(r14, "localDateTime");
        this.d = Date.from(r14.atZone(ZoneId.systemDefault()).toInstant());
        DateTimeFormatter r98 = t.d;
        Objects.requireNonNull(r98, "formatter");
        this.f19864c = r14.atZone(ZoneId.systemDefault()).format(r98);
        return;
    L401:
        if (r90 >= 10) goto L403;
        r88[0] = "200" + String.valueOf(((int[]) r10.f17502b)[0]);
        goto L403
    L396:
        if (r89 >= 100) goto L398;
        r88[0] = "19" + String.valueOf(((int[]) r10.f17502b)[0]);
    L9:
        e = move-exception;
        System.out.println("normStandardTime error:" + e.getMessage());
        goto L19
    L5:
        if (r11.find() == false) goto L19;
        goto L19
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.time.ZonedDateTime] */
    public final void a(LocalDateTime r5) {
        ZoneId r10 = t.f19909a;
        Objects.requireNonNull(r5, "localDateTime");
        DateTimeFormatter r11 = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss").withZone(t.f19909a);
        Objects.requireNonNull(r11, "formatter");
        String[] r12 = r5.atZone(ZoneId.systemDefault()).format(r11).split(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        i4.a r13 = this.g;
        ((int[]) r13.f17502b)[0] = Integer.parseInt(r12[0]);
        ((int[]) r13.f17502b)[1] = Integer.parseInt(r12[1]);
        ((int[]) r13.f17502b)[2] = Integer.parseInt(r12[2]);
        ((int[]) r13.f17502b)[3] = Integer.parseInt(r12[3]);
        ((int[]) r13.f17502b)[4] = Integer.parseInt(r12[4]);
        ((int[]) r13.f17502b)[5] = Integer.parseInt(r12[5]);
    }

    public final void b(int r15) {
        int r5 = 0;
        int r10 = 0;
    L3:
        i4.a r11 = this.g;
        if (r10 >= r15) goto L9;
        if (((int[]) r11.f17502b)[r10] != (-1)) goto L70;
        r10 = r10 + 1;
        goto L3
    L70:
        return;
    L9:
        int r12 = 0;
    L10:
        i4.a r13 = this.f19865h;
        if (r12 >= r15) goto L19;
        int[] r14 = (int[]) r11.f17502b;
        if (r14[r12] != (-1)) goto L17;
        int r16 = ((int[]) r13.f17502b)[r12];
        if (r16 == (-1)) goto L17;
        r14[r12] = r16;
    L17:
        r12 = r12 + 1;
        goto L10
    L19:
        if (this.e != true) goto L26;
        if (r15 != 3) goto L26;
        if (((int[]) r13.f17502b)[r15] < 12) goto L26;
        int[] r17 = (int[]) r11.f17502b;
        int r18 = r17[r15];
        if (r18 >= 12) goto L26;
        r17[r15] = r18 + 12;
    L26:
        this.e = false;
        int r19 = 0;
    L27:
        if (r19 >= r15) goto L32;
        if (((int[]) r11.f17502b)[r19] != (-1)) goto L71;
        r19 = r19 + 1;
        goto L27
    L71:
        return;
    L32:
        this.f.getClass();
        LocalDateTime r20 = LocalDateTime.now();
        String r21 = (String) r13.f17503c;
        if (r21 == null) goto L35;
        String[] r22 = r21.split(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        r20 = LocalDateTime.of(Integer.valueOf(r22[0]).intValue(), Integer.valueOf(r22[1]).intValue(), Integer.valueOf(r22[2]).intValue(), Integer.valueOf(r22[3]).intValue(), Integer.valueOf(r22[4]).intValue(), Integer.valueOf(r22[5]).intValue());
    L35:
        HashMap r23 = f19861i;
        int r24 = r20.get((TemporalField) r23.get(Integer.valueOf(r15)));
        if (r15 == 1) goto L38;
    L40:
        if (r15 != 3) goto L53;
        int r25 = ((int[]) r11.f17502b)[3];
        if (r25 < 0) goto L53;
        if (r25 > 11) goto L53;
        Pattern r26 = A.f19792a0.b();
        String r110 = this.f19862a;
        Matcher r27 = r26.matcher(r110);
        Matcher r111 = A.f19793b0.b().matcher(r110);
        if (r27.find() == true) goto L50;
        if (r111.find() == true) goto L50;
    L55:
        LocalDateTime r112 = r20.plus(1, (TemporalUnit) r23.get(Integer.valueOf(r15 + 9)));
    L56:
        if (r5 >= r15) goto L72;
        ((int[]) r11.f17502b)[r5] = r112.get((TemporalField) r23.get(Integer.valueOf(r5)));
        r5 = r5 + 1;
        goto L56
    L72:
        return;
    L50:
        if (r24 >= (((int[]) r11.f17502b)[3] + 12)) goto L55;
        return;
    L53:
        if (r24 >= ((int[]) r11.f17502b)[r15]) goto L55;
        return;
    L38:
        if (((int[]) r11.f17502b)[1] > r24) goto L40;
    }

    public final String toString() {
        return this.f19862a + " ---> " + this.f19864c;
    }
}
