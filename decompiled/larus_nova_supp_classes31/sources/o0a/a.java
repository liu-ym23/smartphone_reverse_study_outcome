package o0a;

import com.larus.ugc.feed.api.tracker.params.MobFeedStaytimeParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobSessionClickParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobSessionSlideParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobTemplateClickParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobTemplateMenuClickParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobTemplateMenuElementShowParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobTemplateShowParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobUseTemplateMenuShowParamsKmp;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface a {
    void a(MobUseTemplateMenuShowParamsKmp r1);

    void b(MobTemplateClickParamsKmp r1);

    void c(MobFeedStaytimeParamsKmp r1);

    void d(MobSessionClickParamsKmp r1);

    void e(MobTemplateMenuClickParamsKmp r1);

    void f(MobSessionSlideParamsKmp r1);

    void g(MobTemplateShowParamsKmp r1);

    void h(MobTemplateMenuElementShowParamsKmp r1);
}
