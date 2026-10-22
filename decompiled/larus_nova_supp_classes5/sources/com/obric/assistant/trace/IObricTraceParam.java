package com.obric.assistant.trace;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0018\bg\u0018\u0000 #2\u00020\u0001:\u0001#J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u001c\u0010\u0007\u001a\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000bH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\"\u0010\u000f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\fH&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0006H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\fH&J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\fH&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J.\u0010\u001d\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\f2\b\u0010 \u001a\u0004\u0018\u00010\fH&J.\u0010!\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\f2\b\u0010\"\u001a\u0004\u0018\u00010\f2\b\u0010 \u001a\u0004\u0018\u00010\fH&¨\u0006$"}, d2 = {"Lcom/obric/assistant/trace/IObricTraceParam;", "", "initSendMessageExtTrace", "", "setWindowHeight", "height", "", "putLaunchPara", "params", "Lorg/json/JSONObject;", "paramsMap", "", "", "putLaunchEventForMiddlePlatformPara", "putLaunchEventForClientPara", "putSendEventPara", "actionBarKey", "eventName", "setClickTalkSourceType", "sourceType", "setImSpeakConversationMode", "mode", "putReceiveEventPara", "putInputFunctionSwitchPara", "putActionBarEventPara", "putActionBarOptionEventPara", "putWindowTracePara", "putClickEventPara", "putClickTalkEventPara", "putEnterPageEventPara", "currentPage", "previousPage", "enterFrom", "putClickPageEventPara", "actionType", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricTraceParam {
    public static final a a = null;

    static {
        a = a.a;
    }

    void a(JSONObject r1, String r2, String r3, String r4);

    void b(JSONObject r1, String r2, String r3, String r4);

    void c(JSONObject r1, String r2);

    void d(JSONObject r1, String r2);

    void e(JSONObject r1);

    void f(int r1);

    void g(JSONObject r1);

    void h(JSONObject r1);

    void i(JSONObject r1);

    void j();

    void k(JSONObject r1);

    void l(JSONObject r1);

    void m();

    void n(JSONObject r1);

    void o(JSONObject r1);

    void setWindowHeight(int r1);
}
