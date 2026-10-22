package com.larus.audio.utils;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.audio.AudioSyncCallConfig;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.SAMICore;
import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICoreIdentify;
import com.mammon.audiosdk.enums.SAMICorePropertyId;
import com.mammon.audiosdk.structures.SAMICoreAudioBin;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreNonRealtimeTimeStretcherCreateParameter;
import com.mammon.audiosdk.structures.SAMICoreProperty;
import java.io.File;
import java.io.IOException;
import kotlin.Lazy;
import p68.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class m implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ float b;
    public final /* synthetic */ float c;
    public final /* synthetic */ String d;
    public final /* synthetic */ e e;

    public /* synthetic */ m(String r1, float r2, float r3, String r4, e r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r0 = this.a;
        final float r4 = this.b;
        final float r5 = this.c;
        final String r6 = this.d;
        final e r7 = this.e;
        FLogger r2 = FLogger.a;
        r2.i("AudioLoadManager", "[realPlayAudio] pcmPath=" + r0 + ", pitch=" + r4 + ", rate=" + r5 + ", botId=" + r6);
        AudioLoadManager r3 = AudioLoadManager.a;
        r2.i("AudioLoadManager", "[getWavFilePath] filePath" + r0 + ", pitch:" + r4 + ", rate:" + r5 + ", botid:" + r6);
        if (r0.length() != 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L10;
        r2.e("AudioLoadManager", "[getWavFilePath] filepath is empty");
    L8:
        boolean r11 = false;
    L150:
        final String r8 = null;
    L151:
        SAMICore r1 = AudioLoadManager.d;
        if (r1 == null) goto L154;
        r1.SAMICoreDestroyHandle();
    L154:
        if (r8 != null) goto L156;
    L157:
        r11 = true;
    L158:
        if (r11 == false) goto L164;
        FLogger.a.e("AudioLoadManager", "[realPlayAudio] wavPath:" + r8);
        r7.onError();
        if (l1.e == false) goto L186;
        l1.c();
        return;
    L186:
        return;
    L164:
        if (l1.e == false) goto L167;
        l1.d = System.currentTimeMillis();
    L167:
        r7.onBegin();
        com.larus.utils.t0.e(new n(r8, r4, r5, r6, r7));
        return;
    L156:
        if (r8.length() != 0) goto L158;
    L10:
        if (AudioLoadManager.d != null) goto L12;
        r2.i("AudioLoadManager", "[getWavFilePath] create a new samiCore");
        AudioLoadManager.d = new SAMICore();
    L12:
        SAMICoreNonRealtimeTimeStretcherCreateParameter r12 = new SAMICoreNonRealtimeTimeStretcherCreateParameter();
        r12.sampleRate = 24000;
        r12.channels = 1;
        SAMICore r15 = AudioLoadManager.d;
        if (r15 == null) goto L15;
        Lazy r16 = i0.a;
        StringBuilder r13 = new StringBuilder("isEnableSyncAsrTtsSpeechRate config=");
        Lazy r14 = i0.a;
        r13.append(((AudioSyncCallConfig) r14.getValue()).isEnableSyncAsrTtsSpeechRate());
        r2.i("AudioSyncCallConfigUtils", r13.toString());
        r15.setEnableSyncInterface(((AudioSyncCallConfig) r14.getValue()).isEnableSyncAsrTtsSpeechRate());
    L15:
        SAMICore r17 = AudioLoadManager.d;
        if (r17 == null) goto L18;
        Integer r19 = Integer.valueOf(r17.SAMICoreCreateHandleByIdentify(SAMICoreIdentify.SAMICoreIdentify_Voice_Assistant_TimeStretcher, r12));
    L19:
        if (r19 != null) goto L22;
    L23:
        r2.e("AudioLoadManager", "[getWavFilePath] create handle fail, ret=" + r19);
        goto L8
    L22:
        if (r19.intValue() != 0) goto L23;
        SAMICoreProperty r110 = new SAMICoreProperty();
        SAMICorePropertyId r111 = SAMICorePropertyId.SAMICorePropertyId_TimeStretcher_TimeRatio;
        r110.id = r111;
        SAMICoreDataType r112 = SAMICoreDataType.SAMICoreDataType_Float;
        r110.type = r112;
        r110.dataObjectArray = new Float[]{Float.valueOf(r5)};
        r110.dataArrayLen = 1;
        SAMICore r113 = AudioLoadManager.d;
        if (r113 == null) goto L27;
        Integer r114 = Integer.valueOf(r113.SAMICoreSetProperty(r111, r110));
    L28:
        if (r114 != null) goto L31;
    L32:
        r2.e("AudioLoadManager", "[getWavFilePath] set speech rate fail, ret=" + r114);
        goto L8
    L31:
        if (r114.intValue() != 0) goto L32;
        SAMICoreProperty r115 = new SAMICoreProperty();
        SAMICorePropertyId r116 = SAMICorePropertyId.SAMICorePropertyId_TimeStretcher_PitchShift;
        r115.id = r116;
        r115.type = r112;
        r115.dataObjectArray = new Float[]{Float.valueOf(r4)};
        r115.dataArrayLen = 1;
        SAMICore r117 = AudioLoadManager.d;
        if (r117 == null) goto L36;
        Integer r118 = Integer.valueOf(r117.SAMICoreSetProperty(r116, r115));
    L37:
        if (r118 != null) goto L40;
    L41:
        r2.e("AudioLoadManager", "[getWavFilePath] set pitch fail, ret=" + r118);
        goto L8
    L40:
        if (r118.intValue() != 0) goto L41;
        SAMICoreBlock r119 = new SAMICoreBlock();
        r119.dataType = SAMICoreDataType.SAMICoreDataType_String;
        r119.audioData = new String[]{r0};
        SAMICoreBlock r9 = new SAMICoreBlock();
        SAMICore r120 = AudioLoadManager.d;
        if (r120 == null) goto L45;
        Integer r121 = Integer.valueOf(r120.SAMICoreProcess(r119, r9));
    L46:
        if (r121 != null) goto L49;
    L50:
        r2.e("AudioLoadManager", "[getWavFilePath] process fail, ret=" + r121);
        goto L8
    L49:
        if (r121.intValue() != 0) goto L50;
        SAMICoreProperty r122 = new SAMICoreProperty();
        SAMICorePropertyId r123 = SAMICorePropertyId.SAMICorePropertyId_TimeStretcher_GetSampleRate;
        r122.id = r123;
        r122.type = r112;
        SAMICore r124 = AudioLoadManager.d;
        if (r124 == null) goto L54;
        Integer r125 = Integer.valueOf(r124.SAMICoreGetPropertyById(r123, r122));
    L55:
        if (r125 != null) goto L58;
    L59:
        r2.e("AudioLoadManager", "[getWavFilePath] get sample rate fail, ret=" + r125);
    L72:
        int r126 = 24000;
    L73:
        SAMICoreProperty r127 = new SAMICoreProperty();
        SAMICorePropertyId r128 = SAMICorePropertyId.SAMICorePropertyId_TimeStretcher_GetChannel;
        r127.id = r128;
        r127.type = r112;
        SAMICore r129 = AudioLoadManager.d;
        if (r129 == null) goto L76;
        Integer r130 = Integer.valueOf(r129.SAMICoreGetPropertyById(r128, r127));
    L77:
        if (r130 != null) goto L80;
    L81:
        r2.e("AudioLoadManager", "[getWavFilePath] get channel fail, ret=" + r130);
    L94:
        int r131 = 1;
    L95:
        SAMICoreDataType r132 = r9.dataType;
        SAMICoreDataType r133 = SAMICoreDataType.SAMICoreDataType_AudioBin;
        if (r132 != r133) goto L149;
        StringBuilder r20 = new StringBuilder();
        com.larus.audio.tts.c r134 = AudioLoadManager.b;
        if (r134 == null) goto L100;
        r133 = AppHost.a.getApplication();
        String r135 = r134.c(r133);
    L101:
        r20.append(r135);
        r20.append(File.separator);
        r20.append(r6);
        r20.append(".wav");
        String r21 = r20.toString();
        PolarisFileWrapper r136 = new PolarisFileWrapper(r21);     // Catch: Throwable -> L130 IOException -> L132
        if (r136.exists() == true) goto L105;
        r136.createNewFile();     // Catch: Throwable -> L130 IOException -> L132
    L105:
        PolarisFileOutputStreamWrapper r137 = new PolarisFileOutputStreamWrapper(r136);     // Catch: Throwable -> L130 IOException -> L132
        r11 = false;
        Object r22 = r9.audioData[0];     // Catch: IOException -> L122 Throwable -> L141
        if ((r22 instanceof SAMICoreAudioBin) == false) goto L111;
        SAMICoreAudioBin r23 = (SAMICoreAudioBin) r22;     // Catch: IOException -> L122 Throwable -> L141
    L112:
        if (r23 == null) goto L180;
        byte[] r24 = r23.audioData;     // Catch: IOException -> L122 Throwable -> L141
        if (r24 == null) goto L180;
        r137.write(AudioLoadManager.c(r126, r131, r24.length));     // Catch: IOException -> L122 Throwable -> L141
        r137.write(r24);     // Catch: IOException -> L122 Throwable -> L141
        r137.close();     // Catch: IOException -> L119
    L121:
        FLogger.a.i("AudioLoadManager", "[getWavFilePath] wav success: path" + r21);
        r8 = r21;
    L119:
        e = move-exception;
        FLogger.a.e("AudioLoadManager", "[getWavFilePath] wav close error: " + e.getMessage(), e);
    L180:
        r137.close();     // Catch: IOException -> L126
    L126:
        e = e;
        FLogger r25 = FLogger.a;
        StringBuilder r26 = new StringBuilder("[getWavFilePath] wav close error: ");
    L140:
        r26.append(e.getMessage());
        r25.e("AudioLoadManager", r26.toString(), e);
        goto L150
    L111:
        r23 = null;
    L122:
        e = e;
    L134:
        FLogger.a.e("AudioLoadManager", "[getWavFilePath] wav error: " + e.getMessage(), e);     // Catch: Throwable -> L141
        if (r137 == null) goto L150;
        r137.close();     // Catch: IOException -> L138
    L138:
        e = e;
        r25 = FLogger.a;
        r26 = new StringBuilder("[getWavFilePath] wav close error: ");
    L128:
        e = e;
        r11 = false;
        goto L134
    L141:
        th = move-exception;
        Throwable r27 = th;
    L143:
        if (r133 == null) goto L183;
        r133.close();     // Catch: IOException -> L146
        throw r27;
    L146:
        e = move-exception;
        FLogger.a.e("AudioLoadManager", "[getWavFilePath] wav close error: " + e.getMessage(), e);
        throw r27;
    L183:
        throw r27;
    L132:
        e = e;
        r11 = false;
        r137 = null;
    L130:
        th = move-exception;
        r27 = th;
        r133 = null;
        goto L143
    L100:
        r135 = null;
        goto L101
    L149:
        r11 = false;
        r2.e("AudioLoadManager", "[getWavFilePath] out data error");
        goto L150
    L80:
        if (r130.intValue() != 0) goto L81;
        Object[] r138 = r127.dataObjectArray;
        if (r138.length != 0) goto L85;
        boolean r139 = true;
    L87:
        if ((!r139) == false) goto L94;
        Object r140 = r138[0];
        if ((r140 instanceof Float) == false) goto L91;
        Float r141 = (Float) r140;
    L92:
        if (r141 == null) goto L94;
        r131 = (int) r141.floatValue();
        goto L95
    L91:
        r141 = null;
        goto L92
    L85:
        r139 = false;
        goto L87
    L76:
        r130 = null;
        goto L77
    L58:
        if (r125.intValue() != 0) goto L59;
        Object[] r142 = r122.dataObjectArray;
        if (r142.length != 0) goto L63;
        boolean r143 = true;
    L65:
        if ((!r143) == false) goto L72;
        Object r144 = r142[0];
        if ((r144 instanceof Float) == false) goto L69;
        Float r145 = (Float) r144;
    L70:
        if (r145 == null) goto L72;
        r126 = (int) r145.floatValue();
        goto L73
    L69:
        r145 = null;
        goto L70
    L63:
        r143 = false;
        goto L65
    L54:
        r125 = null;
        goto L55
    L45:
        r121 = null;
        goto L46
    L36:
        r118 = null;
        goto L37
    L27:
        r114 = null;
        goto L28
    L18:
        r19 = null;
        goto L19
    L5:
        r10 = false;
        goto L6
    }
}
