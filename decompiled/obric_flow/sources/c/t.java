package c;

import com.zte.miboard.cards.travel.net.data.FlightNetInfoRequest;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/* JADX INFO: loaded from: classes.dex */
interface t {
    @POST("queryFlights2")
    mt.n<Object> a(@Body FlightNetInfoRequest r5, @HeaderMap Map<String, String> r10);
}
