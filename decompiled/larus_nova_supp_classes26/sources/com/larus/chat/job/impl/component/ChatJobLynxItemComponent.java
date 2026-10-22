package com.larus.chat.job.impl.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.chat.job.impl.page.g0;
import com.larus.home.impl.sdk.FlowAppletServiceImpl;
import com.larus.im.bean.job.AIJob;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.e4;
import com.larus.platform.service.c1;
import com.larus.ui.arch.component.external.api.Component;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 '2\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u0011J$\u0010\u0014\u001a\u00020\u0015*\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\rH\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0002J\b\u0010\u001a\u001a\u00020\rH\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\rH\u0002J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u000bH\u0002J\b\u0010\u001f\u001a\u00020\u0011H\u0002J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010!\u001a\u00020\u0011H\u0002J\u000e\u0010\"\u001a\u00020\t*\u0004\u0018\u00010#H\u0002J\u000e\u0010$\u001a\u0004\u0018\u00010#*\u00020\u000fH\u0002J\u0012\u0010%\u001a\u0004\u0018\u00010\t2\u0006\u0010&\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/chat/job/impl/component/ChatJobLynxItemComponent;", "Lcom/larus/ui/arch/component/external/api/Component;", "container", "Landroid/widget/FrameLayout;", "<init>", "(Landroid/widget/FrameLayout;)V", "lynxView", "Lcom/larus/platform/api/IvyPluginView;", "templateUrl", "", "fallbackView", "Landroid/view/View;", "renderGeneration", "", "boundItem", "Lcom/larus/chat/job/impl/page/ChatJobListItem$Job;", "bind", "", "item", "destroy", "lifeCycle", "Lcom/larus/platform/api/IvyPluginViewLifeCycle;", ShareType.URL, "data", "generation", "clearLynxView", "nextRenderGeneration", "isCurrentRender", "", "showLynxView", "view", "showFallbackCard", "updateLynxData", "clearContainerPlaceholderHeight", "toRenderData", "Lorg/json/JSONObject;", "projectPayload", "statusText", "lastRunStatus", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatJobLynxItemComponent extends Component {
    public static final /* synthetic */ int r = 0;
    public final FrameLayout l;
    public e4 m;
    public String n;
    public View o;
    public int p;
    public com.larus.chat.job.impl.page.i.a q;

    public static final class a {
        public a() {
        }

        public static final String a(com.larus.chat.job.impl.page.i.a r1) {
            int r0 = ChatJobLynxItemComponent.r;
            if (r1.b == false) goto L5;
            return "recommend";
        L5:
            return "task";
        }

        public static final String b(AIJob r3) {
            int r0 = ChatJobLynxItemComponent.r;
            StringBuilder r1 = new StringBuilder("id=");
            String r2 = StringsKt.takeLast(r3.getJobId(), 6);
            if (StringsKt.isBlank(r2) == false) goto L5;
            r2 = "blank";
        L5:
            r1.append(r2);
            r1.append(",type=");
            r1.append(r3.getJobType());
            r1.append(",status=");
            r1.append(r3.getStatus());
            r1.append(",contentLength=");
            r1.append(r3.getContent().length());
            r1.append(",extLength=");
            r1.append(r3.getExt().length());
            return r1.toString();
        }
    }

    static {
        new a();
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.larus.chat.job.impl.component.m, java.lang.Object] */
    public final void N2() {
        e4 r0 = this.m;
        if (r0 == null) goto L5;
        r0.destroy();
    L5:
        this.m = null;
        this.n = null;
        this.l.setMinimumHeight(0);
        View r1 = this.o;
        if (r1 != null) goto L8;
        int r2 = fz8.h.a;
        Context r3 = this.l.getContext();
        final ?? r4 = new m(this);
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "onRetry");
        LinearLayout r5 = new LinearLayout(r3);
        r5.setOrientation(1);
        r5.setGravity(17);
        Resources r9 = r3.getResources();
        r5.setMinimumHeight((int) ((157 * WindowDisplayMetricsOverride.apply(r9, r9.getDisplayMetrics()).density) + 0.5f));
        r5.setPadding(i5.q(), i5.q(), i5.q(), i5.q());
        GradientDrawable r8 = gz8.g.a(r3);
        r8.setStroke(i5.b(), gz8.g.d(r3));
        r5.setBackground(r8);
        r5.setClickable(true);
        e1.d(r5, new fz8.g(r4));
        View r6 = new AppCompatImageView(r3);
        r6.setImageResource(2131240031);
        r5.addView(r6, new LinearLayout.LayoutParams(i5.Z(), i5.Z()));
        TextView r7 = new TextView(r3);
        r7.setGravity(17);
        r7.setIncludeFontPadding(false);
        Intrinsics.checkNotNullParameter(r3, "context");
        r7.setTextColor(v19.c.a(2130972082, r3, 2131103146));
        r7.setTextSize(15.0f);
        r7.setLineSpacing(0.0f, 1.5f);
        r7.setTypeface(Typeface.create("sans-serif-medium", 0));
        r7.setText(gz8.f.b("scheduledTasks_taskPage_desc_loadFail"));
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(-2, -2);
        r10.topMargin = i5.h();
        Unit r11 = Unit.INSTANCE;
        r5.addView(r7, r10);
        this.o = r5;
        r1 = r5;
    L8:
        this.l.removeAllViews();
        this.l.addView(r1, new FrameLayout.LayoutParams(-1, -2));
    }

    public ChatJobLynxItemComponent(fz8.k r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        this.l = r2;
    }

    public final void L2(com.larus.chat.job.impl.page.i.a r32) {
        Intrinsics.checkNotNullParameter(r32, "item");
        com.larus.chat.job.impl.page.i.a r0 = this.q;
        if (r0 == null) goto L7;
        AIJob r1 = r0.a;
        if (r1 == null) goto L7;
        String r2 = r1.getJobId();
    L9:
        if (Intrinsics.areEqual(r2, r32.a.getJobId()) == true) goto L11;
        this.o = null;
    L11:
        this.q = r32;
        String r3 = r32.a.getTemplateUrl();
        if (r3 != null) goto L14;
    L255:
        FLogger.a.e("ChatJobLynxItem", "template url is empty cardType=" + a.a(r32) + " job=" + a.b(r32.a));
        N2();
        return;
    L14:
        if ((!StringsKt.isBlank(r3)) == true) goto L17;
        r3 = null;
    L17:
        if (r3 == null) goto L255;
        Uri r4 = y0.j(r3);
        if (r4 != null) goto L21;
    L20:
        String r13 = r3;
        if (r13 == null) goto L255;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L36
        Object r6 = Result.constructor-impl(new JSONObject(r32.a.getContent()));     // Catch: Throwable -> L36
    L39:
        if (Result.isFailure-impl(r6) == false) goto L41;
        r6 = null;
    L41:
        JSONObject r7 = (JSONObject) r6;
        if (r7 != null) goto L44;
        JSONObject r8 = null;
        String r19 = " job=";
        String r17 = "ChatJobLynxItem";
        r13 = r13;
    L225:
        if (r8 == null) goto L229;
        String r9 = new JSONObject().put("widget_data", r8).toString();
        if (r9 == null) goto L229;
    L231:
        if (this.m == null) goto L238;
        String r10 = r13;
        if (Intrinsics.areEqual(this.n, r10) == false) goto L239;
        this.l.setMinimumHeight(0);
        this.p++;
        e4 r11 = this.m;
        if (r11 == null) goto L262;
        r11.updateData(r9);
        return;
    L262:
        return;
    L239:
        e4 r12 = this.m;
        if (r12 == null) goto L242;
        r12.destroy();
    L242:
        this.m = null;
        this.n = null;
        this.l.removeAllViews();
        this.o = null;
        int r14 = this.p + 1;
        this.p = r14;
        c1 r15 = c1.a;
        if (r15.d() == true) goto L245;
        r15.f();
    L245:
        this.n = r10;
        e4 r16 = r15.g(this.l.getContext(), r10, r9, new n(r32, this, r10, r14, r9));
        this.m = r16;
        if (r16 == null) goto L248;
        View r18 = r16.getView();
    L249:
        if (r18 != null) goto L251;
        FLogger.a.e(r17, "create ivy view failed cardType=" + a.a(r32) + r19 + a.b(r32.a));
        N2();
        return;
    L251:
        this.l.setMinimumHeight(0);
        this.o = null;
        this.l.removeAllViews();
        this.l.addView(r18, new FrameLayout.LayoutParams(-1, -2));
        e4 r20 = this.m;
        if (r20 == null) goto L265;
        r20.updateData(r9);
        return;
    L265:
        return;
    L248:
        r18 = null;
        goto L249
    L238:
        r10 = r13;
    L229:
        r9 = "{}";
        goto L231
    L44:
        boolean r21 = r32.b;
        String r110 = MusicAppletPage.KEY_CONVERSATION_ID;
        if (r21 == false) goto L67;
        JSONObject r22 = r7.optJSONObject("recommend_job");
        if (r22 != null) goto L49;
    L66:
        r17 = "ChatJobLynxItem";
    L212:
        r19 = " job=";
        r13 = r13;
        r110 = MusicAppletPage.KEY_CONVERSATION_ID;
        JSONObject r23 = null;
    L213:
        if (r23 == null) goto L224;
        AIJob r24 = r32.a;
        Intrinsics.checkNotNullParameter(r24, "<this>");
        JSONObject r25 = new JSONObject().put("job_id", r24.getJobId()).put("job_type", r24.getJobType()).put("status", r24.getStatus()).put("update_version", r24.getUpdateVersion());
        String r26 = r24.getConversationId();
        if (r26 == null) goto L217;
        r25.put(r110, r26);
    L217:
        JSONObject r27 = r25.put("create_time", r24.getCreateTime()).put("update_time", r24.getUpdateTime()).put("content", r24.getContent()).put("ext", r24.getExt());
        String r28 = r24.getLocalJobId();
        if (r28 == null) goto L220;
        r27.put("local_job_id", r28);
    L220:
        String r29 = r24.getTemplateUrl();
        if (r29 == null) goto L223;
        r27.put("template_url", r29);
    L223:
        r8 = r23.put("job", r27);
        goto L225
    L224:
        r8 = null;
        goto L225
    L49:
        if (r22.optInt("status") != 1) goto L51;
        boolean r30 = true;
    L52:
        if (r30 == true) goto L55;
        r22 = null;
    L55:
        if (r22 == null) goto L66;
        String r31 = r22.optString("job_id");
        if (StringsKt.isBlank(r31) == false) goto L59;
        r31 = r32.a.getJobId();
    L59:
        String r33 = StringsKt.trim(r22.optString("description")).toString();
        if (r33.length() != 0) goto L62;
        boolean r111 = true;
    L63:
        if (r111 == false) goto L65;
        r33 = r22.optString("prompt");
    L65:
        r17 = "ChatJobLynxItem";
        r23 = new JSONObject().put("job_template_id", r31).put("display", new JSONObject().put("title", r22.optString("title")).put("summary", r33));
        r19 = " job=";
        r13 = r13;
        r110 = MusicAppletPage.KEY_CONVERSATION_ID;
        goto L213
    L62:
        r111 = false;
        goto L63
    L51:
        r30 = false;
        goto L52
    L67:
        r17 = "ChatJobLynxItem";
        int r34 = g0.a;
        JSONObject r35 = r7.optJSONObject(g0.a(r32.a.getJobType()));
        if (r35 == null) goto L212;
        JSONObject r36 = new JSONObject().put("job_id", r32.a.getJobId()).put("job_type", r32.a.getJobType()).put(MusicAppletPage.KEY_CONVERSATION_ID, r32.a.getConversationId()).put("enter_method", "cron_job");
        JSONObject r37 = new JSONObject().put("title", r35.optString("title")).put("summary", r35.optString("prompt"));
        int r38 = r32.a.getJobType();
        if (r38 == 1) goto L74;
        if (r38 != 3) goto L76;
        String r39 = gz8.f.b("from_feishu_trigger");
        r19 = " job=";
        r13 = r13;
        r110 = MusicAppletPage.KEY_CONVERSATION_ID;
    L207:
        JSONObject r40 = r37.put("schedule_text", r39);
        if (r35.optInt("last_run_status") != 2) goto L210;
        String r41 = gz8.f.b("scheduledTasks_header_failed");
    L211:
        r23 = r36.put("display", r40.put("status_text", r41).put("status_code", r32.a.getStatus()));
        goto L213
    L210:
        r41 = null;
    L76:
        r19 = " job=";
        r13 = r13;
        r110 = MusicAppletPage.KEY_CONVERSATION_ID;
    L206:
        r39 = null;
        goto L207
    L74:
        JSONObject r42 = r35.optJSONObject("schedule_config");
        if (r42 == null) goto L76;
        if (r42.has("display_frequency") == false) goto L80;
        String r112 = StringsKt.trim(r42.optString("display_frequency")).toString();
    L81:
        int r43 = r42.optInt("repeat_type");
        r19 = " job=";
        if (r43 == 1) goto L84;
        r13 = r13;
        r110 = MusicAppletPage.KEY_CONVERSATION_ID;
        if (r112 == null) goto L119;
        if (r112.length() <= 0) goto L112;
        boolean r44 = true;
    L113:
        if (r44 == true) goto L116;
        r112 = null;
    L116:
        if (r112 == null) goto L119;
    L117:
        r39 = r112;
        goto L207
    L112:
        r44 = false;
    L119:
        if (r43 == 1) goto L206;
        if (r43 != 2) goto L123;
        JSONObject r45 = r42.optJSONObject("time");
        if (r45 == null) goto L205;
        Integer r46 = gz8.e.b(r45, "minute");
        if (r46 == null) goto L205;
        gz8.d r47 = gz8.d.a;
        int r48 = r46.intValue();
        r47.getClass();
        r39 = gz8.d.d(r48);
        if (r39 != null) goto L207;
    L205:
        r39 = gz8.f.e();
        goto L207
    L123:
        if (r43 != 3) goto L125;
        JSONObject r49 = r42.optJSONObject("time");
        if (r49 == null) goto L197;
        String r50 = gz8.e.a(r49);
        if (r50 == null) goto L197;
        r39 = gz8.f.d() + " · " + r50;
        if (r39 != null) goto L207;
    L197:
        r39 = gz8.f.d();
        goto L207
    L125:
        if (r43 == 4) goto L131;
        if (r43 != 5) goto L206;
        if (r42.has("custom_schedule_prompt") == false) goto L206;
        r39 = r42.optString("custom_schedule_prompt");
        goto L207
    L131:
        JSONArray r51 = r42.optJSONArray("weekdays");
        if (r51 == null) goto L134;
        int r113 = r51.length();
    L135:
        IntRange r114 = RangesKt.until(0, r113);
        ArrayList r115 = new ArrayList();
        IntIterator r116 = r114.iterator();
    L137:
        if (r116.hasNext() == false) goto L182;
        int r117 = r116.nextInt();
        gz8.d r210 = gz8.d.a;
        if (r51 == null) goto L141;
        int r118 = r51.optInt(r117);
    L142:
        r210.getClass();
        Integer r119 = gz8.d.e(r118);
        if (r119 != null) goto L146;
    L148:
        if (r119 != null) goto L151;
    L153:
        if (r119 != null) goto L156;
    L158:
        if (r119 != null) goto L161;
    L163:
        if (r119 != null) goto L166;
    L168:
        if (r119 != null) goto L171;
    L173:
        if (r119 != null) goto L176;
    L178:
        String r120 = null;
    L179:
        if (r120 == null) goto L137;
        r115.add(r120);
        goto L137
    L176:
        if (r119.intValue() != 7) goto L178;
        r120 = gz8.f.b("scheduledTasks_newTask_frequency_sun");
        goto L179
    L171:
        if (r119.intValue() != 6) goto L173;
        r120 = gz8.f.b("scheduledTasks_newTask_frequency_sat");
        goto L179
    L166:
        if (r119.intValue() != 5) goto L168;
        r120 = gz8.f.b("scheduledTasks_newTask_frequency_fri");
        goto L179
    L161:
        if (r119.intValue() != 4) goto L163;
        r120 = gz8.f.b("scheduledTasks_newTask_frequency_thur");
        goto L179
    L156:
        if (r119.intValue() != 3) goto L158;
        r120 = gz8.f.b("scheduledTasks_newTask_frequency_wed");
        goto L179
    L151:
        if (r119.intValue() != 2) goto L153;
        r120 = gz8.f.b("scheduledTasks_newTask_frequency_tue");
        goto L179
    L146:
        if (r119.intValue() != 1) goto L148;
        r120 = gz8.f.b("scheduledTasks_newTask_frequency_mon");
        goto L179
    L141:
        r118 = 0;
        goto L142
    L182:
        String r52 = gz8.f.h(r115);
        String[] r121 = new String[2];
        if (StringsKt.isBlank(r52) == false) goto L185;
        r52 = gz8.f.g();
    L185:
        r121[0] = r52;
        JSONObject r53 = r42.optJSONObject("time");
        if (r53 == null) goto L188;
        String r54 = gz8.e.a(r53);
    L189:
        r121[1] = r54;
        r39 = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(r121), " · ", null, null, 0, null, null, 62, null);
        goto L207
    L188:
        r54 = null;
        goto L189
    L134:
        r113 = 0;
        goto L135
    L84:
        if (r42.has("execute_at") == false) goto L86;
        String r55 = r42.optString("execute_at");
    L87:
        if (r55 != null) goto L89;
    L96:
        String r56 = r112;
    L97:
        if (r56 == null) goto L104;
        gz8.d.a.getClass();
        Intrinsics.checkNotNullParameter(r56, "value");
        Long r57 = gz8.d.f(r56);
        if (r57 == null) goto L101;
        String r122 = r55;
        long r58 = r57.longValue();
        String r123 = r122;
        Date r124 = new Date(r58);
        Locale r125 = Locale.getDefault();
        String r59 = DateFormat.getDateInstance(1, r125).format(r124);
        Calendar r126 = Calendar.getInstance(r125);
        r126.setTimeInMillis(r58);
        r39 = r59 + " · " + gz8.d.c(r126.get(11), r126.get(12));
    L102:
        if (r39 != null) goto L207;
    L105:
        if (r112 != null) goto L117;
        r39 = r123;
        goto L207
    L101:
        r123 = r55;
        r39 = null;
        goto L102
    L104:
        r123 = r55;
        r13 = r13;
        r110 = MusicAppletPage.KEY_CONVERSATION_ID;
        goto L105
    L89:
        if (r55.length() <= 0) goto L91;
        boolean r60 = true;
    L92:
        if (r60 == false) goto L94;
        r56 = r55;
    L95:
        if (r56 != null) goto L97;
    L94:
        r56 = null;
        goto L95
    L91:
        r60 = false;
        goto L92
    L86:
        r55 = null;
        goto L87
    L80:
        r112 = null;
    L36:
        th = move-exception;
        Result.Companion r61 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    L21:
        Uri r62 = y0.l(y0.l(y0.l(r4, "loader_name", "forest"), "forest_newly_builtin", "1"), "enable_lynx_generic_fetcher", "1");
        IFlowSdkDepend r63 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r63 == null) goto L24;
        FlowAppletServiceImpl r64 = r63.g0();
    L25:
        if (r64 != null) goto L27;
    L29:
        boolean r65 = false;
    L30:
        if (r65 == false) goto L32;
        r62 = y0.a(r62, r64.f());
    L32:
        r3 = r62.toString();
        goto L20
    L27:
        if (r64.e() != true) goto L29;
        r65 = true;
        goto L30
    L24:
        r64 = null;
    L7:
        r2 = null;
        goto L9
    }

    public static final boolean F2(ChatJobLynxItemComponent r1, String r2, int r3) {
        if (Intrinsics.areEqual(r1.n, r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.p != r3) goto L7;
        return true;
    }
}
