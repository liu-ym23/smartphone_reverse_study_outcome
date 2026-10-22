package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import hq9.y4;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0017\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0016J.\u0010\u0014\u001a\u0004\u0018\u00010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u001cJ\u001a\u0010\u001d\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001e\u001a\u00020\u0005H\u0016J\u0012\u0010\u001f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0005H\u0016J\u001a\u0010!\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001e\u001a\u00020\u0005H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016J\u0012\u0010#\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010$\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010%\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010&\u001a\u00020\u0007H\u0016J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u0007H\u0016J\b\u0010)\u001a\u00020\u0007H\u0016J\u0010\u0010*\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u000f\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010+J\n\u0010,\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00050\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00050\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/larus/bmhome/chat/model/repo/UserSettingRepoServiceNoop;", "Lcom/larus/bmhome/chat/model/repo/IUserSettingRepoService;", "<init>", "()V", "globalTtsSwitch", "", "mainBotUserChangedTtsSwitch", "", "globalUserChangedTtsSwitch", "isInCvsList", "Ljava/lang/Boolean;", "cvsId", "", "mainBotTtsSwitch", "", "botTtsSwitch", "ttsSet", "", "init", "", "requireAllUserConfig", "Lcom/larus/platform/model/UserConfigResponse;", "configTypes", "", "reason", "source", "(Ljava/util/List;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireUpdateDenoiseTrainAuthorizeUserConfig", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setMainBotTtsSwitch", "openTts", "getMainTtsSwitch", "setGlobalTtsSwitch", "setBotTtsSwitch", "getGlobalTtsSwitch", "getTtsSwitch", "hasSetTts", "setTts", "getMainBotUserChangedTtsSwitch", "setGlobalUserChangedTtsSwitch", "switch", "getGlobalUserChangedTtsSwitch", "saveIsInCvsList", "()Ljava/lang/Boolean;", "getCvsId", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class UserSettingRepoServiceNoop implements IUserSettingRepoService {
    public int a;
    public final Map<String, Integer> b;
    public final Map<String, Integer> c;

    public static final class a {
    }

    static {
    }

    public final String Y1() {
        return null;
    }

    public final Boolean c() {
        return null;
    }

    public final Object e(List<Integer> r1, int r2, String r3, Continuation<? super y4> r4) {
        return null;
    }

    public final void init() {
    }

    public UserSettingRepoServiceNoop() {
        this.a = -1;
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        new LinkedHashSet();
    }

    public final int b() {
        return this.a;
    }

    public final int a(String r2) {
        Integer r3 = (Integer) ((LinkedHashMap) this.b).get(r2);
        if (r3 != null) goto L7;
        return -1;
    L7:
        return r3.intValue();
    }

    public final int d(String r2) {
        Integer r3 = (Integer) ((LinkedHashMap) this.c).get(r2);
        if (r3 != null) goto L7;
        return -1;
    L7:
        return r3.intValue();
    }

    public final Object g(Continuation<? super Boolean> r1) {
        return Boxing.boxBoolean(false);
    }

    public final void i(int r1) {
        this.a = r1;
    }

    public final void f(String r2, int r3) {
        if (r2 == null) goto L5;
        Integer r4 = Integer.valueOf(r3);
        this.b.put(r2, r4);
        return;
    }

    public final void h(String r2, int r3) {
        if (r2 == null) goto L5;
        Integer r4 = Integer.valueOf(r3);
        this.c.put(r2, r4);
        return;
    }
}
