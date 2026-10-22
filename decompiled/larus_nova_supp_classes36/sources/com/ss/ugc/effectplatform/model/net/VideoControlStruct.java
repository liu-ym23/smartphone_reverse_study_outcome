package com.ss.ugc.effectplatform.model.net;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0012R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0016\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/VideoControlStruct;", "", "AllowDownload", "", "AllowDuet", "AllowReact", "DraftProgressBar", "", "ShareType", "ShowProgressBar", "PreventDownloadType", "AllowDynamicWallpaper", "TimerStatus", "AllowUseMusic", "HideDownload", "HideDouplus", "AllowStitch", "DownloadSetting", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "Ljava/lang/Boolean;", "Ljava/lang/Integer;", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class VideoControlStruct {
    public Boolean AllowDownload;
    public Boolean AllowDuet;
    public Boolean AllowDynamicWallpaper;
    public Boolean AllowReact;
    public Boolean AllowStitch;
    public Boolean AllowUseMusic;
    public Integer DownloadSetting;
    public Integer DraftProgressBar;
    public Boolean HideDouplus;
    public Boolean HideDownload;
    public Integer PreventDownloadType;
    public Integer ShareType;
    public Integer ShowProgressBar;
    public Integer TimerStatus;

    public VideoControlStruct() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    public VideoControlStruct(Boolean r1, Boolean r2, Boolean r3, Integer r4, Integer r5, Integer r6, Integer r7, Boolean r8, Integer r9, Boolean r10, Boolean r11, Boolean r12, Boolean r13, Integer r14) {
        this.AllowDownload = r1;
        this.AllowDuet = r2;
        this.AllowReact = r3;
        this.DraftProgressBar = r4;
        this.ShareType = r5;
        this.ShowProgressBar = r6;
        this.PreventDownloadType = r7;
        this.AllowDynamicWallpaper = r8;
        this.TimerStatus = r9;
        this.AllowUseMusic = r10;
        this.HideDownload = r11;
        this.HideDouplus = r12;
        this.AllowStitch = r13;
        this.DownloadSetting = r14;
    }

    public /* synthetic */ VideoControlStruct(Boolean r16, Boolean r17, Boolean r18, Integer r19, Integer r20, Integer r21, Integer r22, Boolean r23, Integer r24, Boolean r25, Boolean r26, Boolean r27, Boolean r28, Integer r29, int r30, DefaultConstructorMarker r31) {
        Integer r2 = null;
        if ((r30 & 1) == 0) goto L5;
        Boolean r1 = null;
    L7:
        if ((r30 & 2) == 0) goto L9;
        Boolean r3 = null;
    L11:
        if ((r30 & 4) == 0) goto L13;
        Boolean r4 = null;
    L15:
        if ((r30 & 8) == 0) goto L17;
        Integer r5 = null;
    L19:
        if ((r30 & 16) == 0) goto L21;
        Integer r6 = null;
    L23:
        if ((r30 & 32) == 0) goto L25;
        Integer r7 = null;
    L27:
        if ((r30 & 64) == 0) goto L29;
        Integer r8 = null;
    L31:
        if ((r30 & 128) == 0) goto L33;
        Boolean r9 = null;
    L35:
        if ((r30 & 256) == 0) goto L37;
        Integer r10 = null;
    L39:
        if ((r30 & 512) == 0) goto L41;
        Boolean r11 = null;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        Boolean r12 = null;
    L47:
        if ((r30 & 2048) == 0) goto L49;
        Boolean r13 = null;
    L51:
        if ((r30 & 4096) == 0) goto L53;
        Boolean r14 = null;
    L55:
        if ((r30 & 8192) != 0) goto L58;
        r2 = r29;
    L58:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r2);
        return;
    L53:
        r14 = r28;
        goto L55
    L49:
        r13 = r27;
        goto L51
    L45:
        r12 = r26;
        goto L47
    L41:
        r11 = r25;
        goto L43
    L37:
        r10 = r24;
        goto L39
    L33:
        r9 = r23;
        goto L35
    L29:
        r8 = r22;
        goto L31
    L25:
        r7 = r21;
        goto L27
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r1 = r16;
        goto L7
    }
}
