package h68;

import com.larus.audio.audiov3.task.asr.AsrDataSourceState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface c {
    AsrDataSourceState a();

    int b();

    a prepare();

    a read(byte[] r1);

    a release();

    a start();

    a stop();
}
